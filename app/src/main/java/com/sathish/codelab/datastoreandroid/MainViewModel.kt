package com.sathish.codelab.datastoreandroid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.sathish.codelab.datastoreandroid.data.AndroidApi
import com.sathish.codelab.datastoreandroid.data.ApiRepository
import com.sathish.codelab.datastoreandroid.data.SortBy
import com.sathish.codelab.datastoreandroid.data.SortOrder
import com.sathish.codelab.datastoreandroid.data.UserPreferences
import com.sathish.codelab.datastoreandroid.data.UserPreferencesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.stateIn

class MainViewModel internal constructor(
    apiRepository: ApiRepository, userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    val androidApiUiModelFlow = combine(
        apiRepository.androidApiLevels,
        userPreferencesRepository.userPreferenceFlow,
    ) { apiUiModels: List<AndroidApi>, userPreference: UserPreferences ->
        return@combine AndroidApiUiModel(
            androidApis = filterSortTasks(
                apiUiModels = apiUiModels, userPreferences = userPreference
            ), userPreferences = userPreference
        )
    }.distinctUntilChanged().stateIn(viewModelScope, SharingStarted.WhileSubscribed(),AndroidApiUiModel(
        emptyList(),userPreferencesRepository.currentUserPreferences
    ))

    private fun filterSortTasks(
        apiUiModels: List<AndroidApi>, userPreferences: UserPreferences
    ): List<AndroidApi> {
        return when (userPreferences.sortBy) {
            SortBy.API -> {
                when (userPreferences.sortOrder) {
                    SortOrder.ASC -> apiUiModels.sortedBy { it.apiLevel }
                    SortOrder.DESC -> apiUiModels.sortedByDescending { it.apiLevel }
                }
            }

            SortBy.NAME -> {
                when (userPreferences.sortOrder) {
                    SortOrder.ASC -> apiUiModels.sortedBy { it.name }
                    SortOrder.DESC -> apiUiModels.sortedByDescending { it.name }
                }
            }
        }
    }

}

data class AndroidApiUiModel(
    val androidApis: List<AndroidApi>, val userPreferences: UserPreferences
)

class ViewModelFactory<VM : ViewModel>(
    private val create: () -> VM
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val vm = create()
        if (modelClass.isInstance(vm)) {
            return vm as T
        }
        throw IllegalArgumentException("Can not create ViewModel for class: $modelClass")
    }
}