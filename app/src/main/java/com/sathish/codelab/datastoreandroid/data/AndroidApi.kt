package com.sathish.codelab.datastoreandroid.data

import java.util.Date

data class AndroidApi(
    val apiLevel: String,
    val name: String,
    val launch: Date,
    val supportStopped: Date? =null,
    val currentlySupported: Boolean
) {
    val versionName: String
        get() = "$name - API $apiLevel"
}

