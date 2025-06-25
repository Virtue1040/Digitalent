package com.rafihidayat.digitalent.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
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
fun FormScreen(navController: NavHostController, id: Long? = null) {
    val context = LocalContext.current
    val db = DigitalentDb.getInstance(context)
    val factory = ViewModelFactory(db.dao, db.dao2)
    val formViewModel: FormViewModel = viewModel(factory = factory)

    var nim by remember { mutableStateOf("") }
    var fullName by remember { mutableStateOf("") }
    var kelas by remember { mutableStateOf("") }

    if (id != null) {
        LaunchedEffect(true) {
            val data = formViewModel.getMahasiswa(id) ?: return@LaunchedEffect
            nim = data.nim
            fullName = data.fullName
            kelas = data.kelas
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(
                            id = R.string.app_form
                        )
                    )
                },
                actions = {

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
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (nim.isBlank() || fullName.isBlank() || kelas.isEmpty()) {
                        Toast.makeText(context, R.string.invalid_data, Toast.LENGTH_LONG).show()
                        return@FloatingActionButton
                    }
                    if (id == null) {
                        formViewModel.insert(nim, fullName, kelas)
                        Toast.makeText(context, context.getText(R.string.data_created), Toast.LENGTH_SHORT).show()
                    } else {
                        formViewModel.update(id, nim, fullName, kelas)
                        Toast.makeText(context, context.getText(R.string.data_updated), Toast.LENGTH_SHORT).show()
                    }
                    navController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = stringResource(R.string.savedata),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    ) { padding ->
        ScreenContent(Modifier.padding(padding), navController, nim, fullName, kelas,
            onNimChange = {
                nim = it
            },
            onFullNameChange = {
                fullName = it
            },
            onKelasChange = {
                kelas = it
            },
            onDone = {
                if (nim.isBlank() || fullName.isBlank() || kelas.isEmpty()) {
                    Toast.makeText(context, R.string.invalid_data, Toast.LENGTH_LONG).show()
                    return@ScreenContent
                }
                if (id == null) {
                    formViewModel.insert(nim, fullName, kelas)
                } else {
                    formViewModel.update(id, nim, fullName, kelas)
                }
                navController.popBackStack()
            })
    }
}

@Composable
private fun ScreenContent(modifier: Modifier, navController: NavController,
                          nim: String, fullName: String, kelas: String, onNimChange: (String) -> Unit, onFullNameChange: (String) -> Unit, onKelasChange: (String) -> Unit, onDone: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = nim,
            onValueChange = {
                onNimChange(it)
            },
            label = {
                Text(
                    text = stringResource(R.string.data_nim)
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            shape = RoundedCornerShape(100.dp),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = fullName,
            onValueChange = {
                onFullNameChange(it)
            },
            label = {
                Text(
                    text = stringResource(R.string.data_fullname)
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            shape = RoundedCornerShape(100.dp),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = kelas,
            onValueChange = {
                onKelasChange(it)
            },
            label = {
                Text(
                    text = stringResource(R.string.data_kelas)
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    onDone()
                }
            ),
            shape = RoundedCornerShape(100.dp),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FormScreenPreview() {
    ThemeController {
        FormScreen(rememberNavController())
    }
}