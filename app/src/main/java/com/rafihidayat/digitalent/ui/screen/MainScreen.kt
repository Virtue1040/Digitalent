package com.rafihidayat.digitalent.ui.screen

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rafihidayat.digitalent.ui.theme.ThemeController
import com.rafihidayat.digitalent.R
import com.rafihidayat.digitalent.model.User
import com.rafihidayat.digitalent.navigation.Screen
import com.rafihidayat.digitalent.util.SettingsDataStore
import com.rafihidayat.digitalent.util.UserDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    val context = LocalContext.current

    val userDataStore = UserDataStore(context)

    val settingDataStore = SettingsDataStore(context)
    val theme by settingDataStore.themeFlow.collectAsState(true)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(
                            id = R.string.app_dashboard
                        )
                    )
                },
                actions = {
//                    IconButton(
//                        onClick = {
//                            CoroutineScope(Dispatchers.IO).launch {
//                                settingDataStore.saveTheme(!theme)
//                            }
//                        }
//                    ) {
//                        Icon(
//                            painter = painterResource(
//                                R.drawable.baseline_color_lens_24
//                            ),
//                            contentDescription = stringResource(
//                                R.string.change_theme
//                            ),
//                            tint = MaterialTheme.colorScheme.primary
//                        )
//                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            CoroutineScope(Dispatchers.IO).launch {
                                userDataStore.saveData(User())
                            }
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_logout_24),
                            contentDescription = stringResource(R.string.logout),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        },
    ) { padding ->
        ScreenContent(context, Modifier.padding(padding), navController)
    }
}

@Composable
private fun ScreenContent(context: Context, modifier: Modifier, navController: NavController) {
    val userDataStore = UserDataStore(context)
    val userData by userDataStore.userFlow.collectAsState(User())

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(60.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.mahasiswa512),
                    contentDescription = stringResource(R.string.logo_mahasiswa)
                )
                Text(
                    text = stringResource(R.string.welcome, userData.fullName),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Spacer(modifier = Modifier.padding(5.dp))
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(230, 0 , 38)),
                border = BorderStroke(0.dp, Color.Transparent),
                onClick = {
                    navController.navigate(Screen.list.route)
                }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.baseline_person_24),
                        contentDescription = stringResource(R.string.showdata),
                        tint = MaterialTheme.colorScheme.surface
                    )
                    Text(
                        text = stringResource(R.string.showdata),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.surface
                    )
                }
            }
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0, 112, 255)),
                border = BorderStroke(0.dp, Color.Transparent),
                onClick = {
                    navController.navigate(Screen.newData.route)
                }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.baseline_person_add_alt_1_24),
                        contentDescription = stringResource(R.string.showdata),
                        tint = MaterialTheme.colorScheme.surface
                    )
                    Text(
                        text = stringResource(R.string.inputdata),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.surface
                    )
                }
            }
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(255, 225, 53)),
                border = BorderStroke(0.dp, Color.Transparent),
                onClick = {
                    navController.navigate(Screen.information.route)
                }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.baseline_info_24),
                        contentDescription = stringResource(R.string.showdata),
                        tint = MaterialTheme.colorScheme.surface
                    )
                    Text(
                        text = stringResource(R.string.information),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.surface
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    ThemeController {
        MainScreen(rememberNavController())
    }
}