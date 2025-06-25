package com.rafihidayat.digitalent.ui.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rafihidayat.digitalent.ui.theme.ThemeController
import com.rafihidayat.digitalent.R
import com.rafihidayat.digitalent.database.DigitalentDb
import com.rafihidayat.digitalent.model.Mahasiswa
import com.rafihidayat.digitalent.navigation.Screen
import com.rafihidayat.digitalent.ui.dialog.ActionDialog
import com.rafihidayat.digitalent.ui.dialog.HapusDialog
import com.rafihidayat.digitalent.ui.viewmodel.FormViewModel
import com.rafihidayat.digitalent.ui.viewmodel.ListViewModel
import com.rafihidayat.digitalent.util.SettingsDataStore
import com.rafihidayat.digitalent.util.ViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(navController: NavHostController) {
    val context = LocalContext.current

    val settingDataStore = SettingsDataStore(context)
    val showList by settingDataStore.layoutFlow.collectAsState(true)
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
                    IconButton(
                        onClick = {
                            CoroutineScope(Dispatchers.IO).launch {
                                settingDataStore.saveLayout(!showList)
                            }
                        }
                    ) {
                        Icon(
                            painter = painterResource(
                                if (showList) R.drawable.baseline_grid_view_24
                                else R.drawable.baseline_view_list_24
                            ),
                            contentDescription = stringResource(
                                if (showList) R.string.grid
                                else R.string.list
                            ),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
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
                    navController.navigate(Screen.newData.route)
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = stringResource(R.string.adddata),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    ) { padding ->
        ScreenContent(context, Modifier.padding(padding), navController,
            showList)
    }
}

@Composable
private fun GridItem(mahasiswa: Mahasiswa, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable {
            onClick()
        },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(1.dp, DividerDefaults.color),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = mahasiswa.nim,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = mahasiswa.fullName,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )
            Column(
                modifier = Modifier.fillMaxWidth().background(
                    MaterialTheme.colorScheme.primaryContainer,
                    shape = MaterialTheme.shapes.small
                ).padding(8.dp)
            ) {
                Text(
                    text = stringResource(R.string.clickedit),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
private fun ListItem(mahasiswa: Mahasiswa, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = mahasiswa.nim,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = mahasiswa.fullName,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Column(
                modifier = Modifier.fillMaxWidth().background(
                    MaterialTheme.colorScheme.primaryContainer,
                    shape = MaterialTheme.shapes.small
                ).padding(8.dp)
            ) {
                Text(
                    text = stringResource(R.string.clickedit),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
private fun ScreenContent(context: Context, modifier: Modifier, navController: NavController, showList : Boolean) {
    val db = DigitalentDb.getInstance(context)
    val factory = ViewModelFactory(db.dao, db.dao2)
    val listViewModel: ListViewModel = viewModel(factory = factory)
    val formViewModel: FormViewModel = viewModel(factory = factory)
    val data by listViewModel.data.collectAsState()

    var showAction by remember { mutableLongStateOf(0L) }
    var showDelete by remember { mutableLongStateOf(0L) }

    if (showDelete != 0L) {
        HapusDialog(
            onDismissRequest = {
                showDelete = 0L
            }
        ) {
            formViewModel.delete(showDelete)
            Toast.makeText(context, context.getText(R.string.data_deleted), Toast.LENGTH_SHORT).show()
            showDelete = 0L
        }
    }

    if (showAction != 0L) {
        ActionDialog(
            onDismissRequest = {
                showAction = 0L
            },
            onDetail = {
                navController.navigate(Screen.detailData.withId(showAction))
                showAction = 0L
            },
            onUpdate = {
                navController.navigate(Screen.editData.withId(showAction))
                showAction = 0L
            },
            onDelete = {
                showDelete = showAction
                showAction = 0L
            }
        )
    }

    if (data.isEmpty()) {
        Column (
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.emptylist)
            )
        }
    } else {
        if (showList) {
            LazyColumn(
                modifier = modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 84.dp),
            ) {
                items(data) {
                    ListItem(mahasiswa = it) {
                        showAction = it.id
                    }
                    HorizontalDivider()
                }
            }
        } else {
            LazyVerticalStaggeredGrid(
                modifier = modifier.fillMaxSize(),
                columns = StaggeredGridCells.Fixed(2),
                verticalItemSpacing = 8.dp,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(8.dp, 8.dp, 8.dp, 84.dp)
            ) {
                items(data) {
                    GridItem(mahasiswa = it) {
                        showAction = it.id
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    ThemeController {
        ListScreen(rememberNavController())
    }
}