package com.example.mms.service

import android.content.Context
import com.example.mms.database.inApp.SingletonDatabase
import com.example.mms.database.jsonMedicines.JsonDatabase
import com.example.mms.model.SideEffects

class SideEffectsService(context: Context) {
    private val jsonDatabase = JsonDatabase(context)

    private fun getSideEffects(): Map<String, Map<String, String>> {
        return this.jsonDatabase.getSideEffects()
    }

    fun getSideEffectsByMedicineId(medicineId: Long): SideEffects? {
        val medicineSideEffects = this.getSideEffects()[medicineId.toString()] ?: mapOf()

        return if (medicineSideEffects.isEmpty()) {
            null
        } else {
            SideEffects(
                fullInfoUrl = medicineSideEffects["full_info_url"] ?: "",
                posology = medicineSideEffects["posology"],
                contraindications = medicineSideEffects["contraindications"],
                specialWarningsAndPrecautions = medicineSideEffects["special_warnings_and_precautions"],
                interactionsOtherMedicines = medicineSideEffects["interactions_other_medicines"],
                pregnancy = medicineSideEffects["pregnancy"],
                drive = medicineSideEffects["drive"],
                sideEffects = medicineSideEffects["side_effects"],
                shelfLife = medicineSideEffects["shelf_life"]
            )
        }
    }
}
