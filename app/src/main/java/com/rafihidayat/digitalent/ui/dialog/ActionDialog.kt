package com.rafihidayat.digitalent.ui.dialog

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.rafihidayat.digitalent.R
import com.rafihidayat.digitalent.ui.theme.ThemeController

@Composable
fun ActionDialog(onDismissRequest: () -> Unit, onDetail: () -> Unit, onUpdate: () -> Unit, onDelete: () -> Unit) {
    Dialog(
        onDismissRequest = {
            onDismissRequest()
        }
    ) {
        Card(
            modifier = Modifier.padding(8.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    style = MaterialTheme.typography.titleLarge,
                    text = stringResource(R.string.actions)
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        onDetail()
                    }
                ) {
                    Text(
                        text = stringResource(R.string.showdata)
                    )
                }
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        onUpdate()
                    }
                ) {
                    Text(
                        text = stringResource(R.string.updatedata)
                    )
                }
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        onDelete()
                    }
                ) {
                    Text(
                        text = stringResource(R.string.deletedata)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DialogActionPreview() {
    ThemeController {
        ActionDialog(
            onDismissRequest = {},
            onDetail = {},
            onUpdate = {},
            onDelete = {}
        )
    }
}