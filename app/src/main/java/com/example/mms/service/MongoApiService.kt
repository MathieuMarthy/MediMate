package com.example.mms.service

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.example.mms.constant.API_URL_MONGO
import com.example.mms.database.mongoObjects.MongoVersion
import com.example.mms.model.medicines.Medicine
import kotlinx.serialization.decodeFromString


/**
 * Service to communicate with the API
 * can get medicines and version of the database
 * Singleton pattern
 *
 * @param context The context of the application
 * @property url The url of the api
 * @property queue The queue of the requests
 * @property json The json parser
 */
class MongoApiService private constructor(context: Context) : Api(context, API_URL_MONGO) {

    /**
     * Get the version of the database and medicines to update if the local version is not up to date
     *
     * @param localVersion The version of the local database
     * @param callback The callback to call when the version and medicines to update are received
     * @param callbackError The callback to call when an error occurred
     */
    fun getMedicinesCodesToUpdate(
        localVersion: Int,
        callback: (version: MongoVersion) -> Unit,
        callbackError: () -> Unit
    ) {
        // build the request
        val stringRequest = StringRequest(
            Request.Method.GET, this.makeUrl("version/$localVersion"),
            { response ->
                try {
                    // try to parse the response into a version
                    val version = this.json.decodeFromString<MongoVersion>(response)
                    callback(version)
                } catch (e: Exception) {
                    // if an error occurred, log and call the error callback
                    Log.d("parse_json", "error: $e")
                    callbackError()
                }
            },
            {
                // if the request failed, call the error callback
                callbackError()
            })

        queue.add(stringRequest)
    }

    /**
     * Get a medicine from the database
     *
     * @param codeCis The code cis of the medicine to get
     * @param callback The callback to call when the medicine is received
     * @param errorCallback The callback to call when an error occurred
     */
    fun getMedicine(codeCis: Int, callback: (Medicine) -> Unit, errorCallback: () -> Unit) {
        // build the request
        val stringRequest = StringRequest(
            Request.Method.GET, this.makeUrl("medicine/$codeCis"),
            { response ->
                try {
                    // try to parse the response into a medicine
                    val medicine = this.json.decodeFromString<Medicine>(response)
                    callback(medicine)
                } catch (e: Exception) {
                    Log.d("json", "error: $e")
                }
            },
            {
                // if the request failed, call the error callback
                errorCallback()
            })

        queue.add(stringRequest)
    }

    /**
     * Singleton pattern
     */
    companion object {
        @Volatile
        private var INSTANCE: MongoApiService? = null

        /**
         * get the instance of the service
         */
        fun getInstance(context: Context): MongoApiService =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: MongoApiService(context).also {
                    INSTANCE = it
                }
            }
    }
}
