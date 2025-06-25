package com.rafihidayat.digitalent.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rafihidayat.digitalent.ui.theme.ThemeController
import com.rafihidayat.digitalent.R
import com.rafihidayat.digitalent.database.DigitalentDb
import com.rafihidayat.digitalent.ui.viewmodel.FormViewModel
import com.rafihidayat.digitalent.util.ViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavHostController, id: Long) {
    val context = LocalContext.current
    val db = DigitalentDb.getInstance(context)
    val factory = ViewModelFactory(db.dao, db.dao2)
    val formViewModel: FormViewModel = viewModel(factory = factory)

    var nim by remember { mutableStateOf("") }
    var fullName by remember { mutableStateOf("") }
    var kelas by remember { mutableStateOf("") }

    LaunchedEffect(true) {
        val data = formViewModel.getMahasiswa(id) ?: return@LaunchedEffect
        nim = data.nim
        fullName = data.fullName
        kelas = data.kelas
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(
                            id = R.string.app_detail
                        )
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        }
    ) { padding ->
        ScreenContent(Modifier.padding(padding), navController,
            nim, fullName, kelas)
    }
}

@Composable
private fun Detail(
    title: String,
    value: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().background(
                MaterialTheme.colorScheme.primaryContainer,
                shape = MaterialTheme.shapes.small
            ).padding(8.dp)
        ) {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.primary
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp),
        ) {
            value()
        }
    }
}

@Composable
private fun ScreenContent(modifier: Modifier, navController: NavController,
                          nim : String, fullName : String, kelas: String) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 84.dp)
    ) {
        item {
            Detail(
                title = stringResource(R.string.data_nim),
                value = {
                    Text(
                        text = nim,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            )
        }

        item {
            Detail(
                title = stringResource(R.string.data_fullname),
                value = {
                    Text(
                        text = fullName,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            )
        }
        item {
            Detail(
                title = stringResource(R.string.data_kelas),
                value = {
                    Text(
                        text = kelas,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailScreenPreview() {
    ThemeController {
        DetailScreen(rememberNavController(), 0)
    }
}