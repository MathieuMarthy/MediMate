package com.example.mms.model

import android.content.Context
import com.example.mms.R
import kotlinx.serialization.Serializable


class ShoawbleItem(
    val title: String,
    val content: String
)

@Serializable
class SideEffects(
    val fullInfoUrl: String,
    val posology: String?,
    val pregnancy: String?,
    val drive: String?,
    val sideEffects: String?,
) {
    fun isEmpty(): Boolean {
        return this.fullInfoUrl.isEmpty() &&
                this.posology.isNullOrEmpty() &&
                this.pregnancy.isNullOrEmpty() &&
                this.drive.isNullOrEmpty() &&
                this.sideEffects.isNullOrEmpty()
    }

    fun isNotEmpty(): Boolean {
        return !this.isEmpty()
    }

    fun getShowableItems(context: Context): List<ShoawbleItem> {
        val showableItems = mutableListOf<ShoawbleItem>()

        if (this.posology != null) {
            showableItems.add(ShoawbleItem(context.getString(R.string.Posology), this.posology))
        }

        if (this.pregnancy != null) {
            showableItems.add(ShoawbleItem(context.getString(R.string.Pregnancy), this.pregnancy))
        }

        if (this.drive != null) {
            showableItems.add(ShoawbleItem(context.getString(R.string.Drive), this.drive))
        }

        if (this.sideEffects != null) {
            showableItems.add(
                ShoawbleItem(
                    context.getString(R.string.effets_secondaires),
                    this.sideEffects
                )
            )
        }

        return showableItems
    }
}
