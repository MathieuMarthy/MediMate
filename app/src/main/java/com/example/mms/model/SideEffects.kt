package com.example.mms.model

import kotlinx.serialization.Serializable

@Serializable
class SideEffects (
    val fullInfoUrl: String,
    val posology: String?,
    val contraindications: String?,
    val specialWarningsAndPrecautions: String?,
    val interactionsOtherMedicines: String?,
    val pregnancy: String?,
    val drive: String?,
    val sideEffects: String?,
    val shelfLife: String?,
) {
    fun isEmpty(): Boolean {
        return this.fullInfoUrl.isEmpty() &&
                this.posology.isNullOrEmpty() &&
                this.contraindications.isNullOrEmpty() &&
                this.specialWarningsAndPrecautions.isNullOrEmpty() &&
                this.interactionsOtherMedicines.isNullOrEmpty() &&
                this.pregnancy.isNullOrEmpty() &&
                this.drive.isNullOrEmpty() &&
                this.sideEffects.isNullOrEmpty() &&
                this.shelfLife.isNullOrEmpty()
    }

    fun isNotEmpty(): Boolean {
        return !this.isEmpty()
    }
}
