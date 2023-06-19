package com.sathish.codelab.datastoreandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sathish.codelab.datastoreandroid.data.AndroidApi
import com.sathish.codelab.datastoreandroid.data.ApiRepository
import com.sathish.codelab.datastoreandroid.data.UserPreferencesRepository
import com.sathish.codelab.datastoreandroid.ui.theme.DataStoreAndroidTheme
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelFactory {
            MainViewModel(ApiRepository, UserPreferencesRepository.getInstance(this))
        }.create(MainViewModel::class.java)

        setContent {
            DataStoreAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AndroidAPIListScreen(viewModel)
                }
            }
        }
    }
}

@Composable
fun AndroidAPIListScreen(mainViewModel: MainViewModel) {
    val androidApiUiModel by mainViewModel.androidApiUiModelFlow.collectAsState()
    AndroidApiList(uiModel = androidApiUiModel)
}

@Composable
fun AndroidApiList(uiModel: AndroidApiUiModel) {
    LazyColumn {
        items(uiModel.androidApis) { androidApi ->
            AndroidApiItem(androidApi = androidApi)

            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun AndroidApiItem(androidApi: AndroidApi) {
    val dateFormat = SimpleDateFormat("MMM d, yyyy", Locale.getDefault())
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(text = "API Level: ${androidApi.apiLevel}")
        Text(text = "Name: ${androidApi.name}")
        Text(text = "Launch Date: ${dateFormat.format(androidApi.launch)}")
        if (androidApi.supportStopped != null) {
            Text(text = "Support Stopped: ${dateFormat.format(androidApi.supportStopped)}")
        }
        Text(text = "Currently Supported: ${androidApi.currentlySupported}")
    }
}
