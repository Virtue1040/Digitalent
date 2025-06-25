package com.rafihidayat.digitalent.ui.screen

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rafihidayat.digitalent.R
import com.rafihidayat.digitalent.database.DigitalentDb
import com.rafihidayat.digitalent.model.User
import com.rafihidayat.digitalent.navigation.Screen
import com.rafihidayat.digitalent.ui.theme.ThemeController
import com.rafihidayat.digitalent.ui.viewmodel.RegisterViewModel
import com.rafihidayat.digitalent.util.UserDataStore
import com.rafihidayat.digitalent.util.ViewModelFactory
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(navController: NavHostController) {
    Scaffold { padding ->
        ScreenContent(Modifier.padding(padding), navController)
    }
}

@Composable
private fun ScreenContent(modifier: Modifier, navController: NavController) {
    val context = LocalContext.current
    val db = DigitalentDb.getInstance(context)
    val factory = ViewModelFactory(db.dao, db.dao2)

    val registerViewModel: RegisterViewModel = viewModel(factory = factory)
    val userDataStore = UserDataStore(context)

    var username by remember { mutableStateOf("") }
    var fullName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmedPassword by remember { mutableStateOf("") }

    var usernameError by remember { mutableStateOf(false) }
    var fullnameError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }
    var confirmedpasswordError by remember { mutableStateOf(false) }

    val userData by userDataStore.userFlow.collectAsState(User())

    val coroutineScopes = rememberCoroutineScope()

    if (userData.id > 0L) {
        navController.navigate(Screen.main.route)
        Toast.makeText(context, context.getText(R.string.user_registered), Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(60.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate(Screen.register.route)
                    },
                text = stringResource(R.string.register),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center
            )
            Spacer(
                modifier = Modifier.padding(5.dp)
            )
            OutlinedTextField(
                value = username,
                onValueChange = {
                    username = it
                },
                label = {
                    Text(
                        text = stringResource(R.string.username)
                    )
                },
                singleLine = true,
                isError = usernameError,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                shape = RoundedCornerShape(100.dp),
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = fullName,
                onValueChange = {
                    fullName = it
                },
                label = {
                    Text(
                        text = stringResource(R.string.fullname)
                    )
                },
                singleLine = true,
                isError = fullnameError,
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    imeAction = ImeAction.Next
                ),
                shape = RoundedCornerShape(100.dp),
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                label = {
                    Text(
                        text = stringResource(R.string.password)
                    )
                },
                singleLine = true,
                isError = passwordError,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                shape = RoundedCornerShape(100.dp),
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = confirmedPassword,
                onValueChange = {
                    confirmedPassword = it
                },
                label = {
                    Text(
                        text = stringResource(R.string.confirmedpassword)
                    )
                },
                singleLine = true,
                isError = confirmedpasswordError,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                visualTransformation = PasswordVisualTransformation(),
                keyboardActions = KeyboardActions(
                    onDone = {
                        if (username.isNotEmpty() || fullName.isNotEmpty() || password.isNotEmpty() || confirmedPassword.isNotEmpty()) {
                            if (password.length < 8) {
                                Toast.makeText(context, context.getText(R.string.invalid_register_password_validation), Toast.LENGTH_SHORT).show()
                                return@KeyboardActions
                            }
                            if (password == confirmedPassword) {
                                coroutineScopes.launch {
                                    val user = registerViewModel.register(
                                        username,
                                        fullName,
                                        password,
                                        confirmedPassword
                                    )
                                    if (user != null) {
                                        userDataStore.saveData(user)
                                    } else {
                                        Toast.makeText(context, context.getText(R.string.invalid_register_wrong), Toast.LENGTH_SHORT).show()
                                    }
                                }
                            } else {
                                Toast.makeText(context, context.getText(R.string.invalid_register_wrong_password), Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(context, context.getText(R.string.invalid_register), Toast.LENGTH_SHORT).show()
                        }
                    }
                ),
                shape = RoundedCornerShape(100.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.padding(10.dp)
            )

            OutlinedButton(
                modifier = Modifier.fillMaxWidth().background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(100.dp)),
                border = BorderStroke(0.dp, Color.Transparent),
                onClick = {
                    if (username.isNotEmpty() && fullName.isNotEmpty() && password.isNotEmpty() && confirmedPassword.isNotEmpty()) {
                        usernameError = false
                        fullnameError = false
                        passwordError = false
                        confirmedpasswordError = false

                        if (password.length < 8) {
                            Toast.makeText(context, context.getText(R.string.invalid_register_password_validation), Toast.LENGTH_SHORT).show()
                            passwordError = true
                            return@OutlinedButton
                        }
                        if (password == confirmedPassword) {
                            coroutineScopes.launch {
                                val user = registerViewModel.register(
                                    username,
                                    fullName,
                                    password,
                                    confirmedPassword
                                )
                                if (user != null) {
                                    userDataStore.saveData(user)
                                } else {
                                    Toast.makeText(context, context.getText(R.string.invalid_register_wrong), Toast.LENGTH_SHORT).show()
                                    usernameError = true
                                }
                            }
                        } else {
                            confirmedpasswordError = true
                            Toast.makeText(context, context.getText(R.string.invalid_register_wrong_password), Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(context, context.getText(R.string.invalid_register), Toast.LENGTH_SHORT).show()
                    }
                }
            ) {
                Text(
                    text = stringResource(R.string.register),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.popBackStack()
                    },
                text = stringResource(R.string.back_login),
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RegisterPreview() {
    ThemeController {
        RegisterScreen(rememberNavController())
    }
}