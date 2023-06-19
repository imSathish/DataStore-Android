package com.sathish.codelab.datastoreandroid.data

import android.content.Context
import androidx.core.content.edit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private const val USER_PREFERENCES_NAME = "user_preferences"
private const val SORT_ORDER_KEY = "sort_order"
private const val SORT_BY_KEY = "sort_by"

enum class SortOrder {
    ASC, DESC
}

enum class SortBy {
    NAME, API
}

data class UserPreferences(
    val sortBy: SortBy, val sortOrder: SortOrder
)

/**
 * Class that handles saving and retrieving user preferences
 */
class UserPreferencesRepository private constructor(context: Context) {

    private val sharedPreferences =
        context.applicationContext.getSharedPreferences(USER_PREFERENCES_NAME, Context.MODE_PRIVATE)

    // Keep the sort order as a stream of changes
    private val _userPreferenceFlow = MutableStateFlow(userPreferences)
    val userPreferenceFlow: StateFlow<UserPreferences> = _userPreferenceFlow

    /**
     * Get the current sort order. By default, the sort order is None.
     */
    val currentUserPreferences: UserPreferences
        get() = userPreferences

    private val userPreferences: UserPreferences
        get() {
            val order = sharedPreferences.getString(SORT_ORDER_KEY, SortOrder.ASC.name)
            val sortBy = sharedPreferences.getString(SORT_BY_KEY, SortBy.API.name)
            return UserPreferences(
                sortBy = SortBy.valueOf(sortBy ?: SortBy.API.name),
                sortOrder = SortOrder.valueOf(order ?: SortOrder.ASC.name)
            )
        }

    private fun saveSortOrder(sortOrder: SortOrder) {
        sharedPreferences.edit {
            putString(SORT_ORDER_KEY, sortOrder.name)
        }
    }

    private fun saveSortBy(sortBy: SortBy) {
        sharedPreferences.edit {
            putString(SORT_BY_KEY, sortBy.name)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: UserPreferencesRepository? = null

        fun getInstance(context: Context): UserPreferencesRepository {
            return INSTANCE ?: synchronized(this) {
                INSTANCE?.let {
                    return it
                }

                val instance = UserPreferencesRepository(context)
                INSTANCE = instance
                instance
            }
        }
    }
}