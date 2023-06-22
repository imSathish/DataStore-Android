package com.sathish.codelab.datastoreandroid

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.sathish.codelab.datastoreandroid.data.AndroidApi
import com.sathish.codelab.datastoreandroid.data.ApiRepository
import com.sathish.codelab.datastoreandroid.data.UserPreferencesRepository
import com.sathish.codelab.datastoreandroid.ui.theme.DataStoreAndroidTheme
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelFactory {
            MainViewModel(ApiRepository, UserPreferencesRepository.getInstance(this))
        }.create(MainViewModel::class.java)

        setContent {
            DataStoreAndroidTheme {
                Scaffold(topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "DataStore Android learning")
                        }
                    )
                }) { paddingValues ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {
                        AndroidAPIListScreen(viewModel)
                    }

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
        }
    }
}

@Composable
fun AndroidApiItem(androidApi: AndroidApi) {
    val dateFormat = SimpleDateFormat("MMM d, yyyy", Locale.getDefault())
    val current = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { Toast.makeText(current,"You clicked ${androidApi.name}",Toast.LENGTH_SHORT).show() }
    ) {
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
}
