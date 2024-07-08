package io.usmon.whoops.internal.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BugReport
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import io.usmon.whoops.R

/**
 * Composable function to display a bottom bar with buttons for copying and reporting an error.
 *
 * @param log The error message to display.
 * @param versionReport The version information to include in the error report.
 * @param reportUrl Optional URL to report the error to. If null, the "Report" button will be hidden.
 * @param onExit Callback function to exit the application.
 * @param modifier Modifier for the bottom bar.
 * @param uriOpener UriHandler to open the report URL.
 * @param clipboardManager ClipboardManager to copy the error message.
 */
@Composable
internal fun BottomBar(
    log: String,
    versionReport: String,
    reportUrl: String?,
    onExit: () -> Unit,
    modifier: Modifier = Modifier,
    uriOpener: UriHandler = LocalUriHandler.current,
    clipboardManager: ClipboardManager = LocalClipboardManager.current,
) {
    val annotatedErrorMessage = AnnotatedString(versionReport)
        .plus(AnnotatedString("\n"))
        .plus(AnnotatedString(log))

    Row(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(vertical = 8.dp)
    ) {
        IconButton(
            icon = Icons.Outlined.BugReport,
            text = stringResource(R.string.copy_and_exit),
            onClick = {
                clipboardManager.setText(annotatedErrorMessage)
                onExit()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .weight(1f),
        )
        if (reportUrl != null) {
            Spacer(modifier = Modifier.width(12.dp))
            IconButton(
                icon = Icons.Outlined.BugReport,
                text = stringResource(R.string.report),
                onClick = {
                    clipboardManager.setText(annotatedErrorMessage)
                    uriOpener.openUri(reportUrl)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp)
                    .weight(1f),
            )
        }
    }
}
