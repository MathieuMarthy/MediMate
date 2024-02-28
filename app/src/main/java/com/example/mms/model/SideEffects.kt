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
)
