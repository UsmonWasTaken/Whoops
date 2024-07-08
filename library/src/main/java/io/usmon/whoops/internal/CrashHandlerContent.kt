package io.usmon.whoops.internal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BugReport
import androidx.compose.material.icons.outlined.PermDeviceInformation
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import io.usmon.whoops.R
import io.usmon.whoops.internal.component.BottomBar
import io.usmon.whoops.internal.component.ExpandableCard

/**
 * Composable that displays the crash report screen.
 *
 * @param log The error message to display.
 * @param versionReport A string containing the device and app version information.
 * @param reportUrl The URL to the crash report.
 * @param onExit A callback to exit the app.
 */
@Composable
internal fun CrashReportContent(
    log: String,
    versionReport: String,
    reportUrl: String?,
    onExit: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            HorizontalDivider()
            BottomBar(
                versionReport = versionReport,
                log = log,
                reportUrl = reportUrl,
                onExit = onExit,
            )
        },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {
            Icon(
                imageVector = Icons.Outlined.BugReport,
                contentDescription = stringResource(R.string.cd_bug_occurred_icon),
                modifier = Modifier
                    .padding(start = 16.dp)
                    .padding(top = 16.dp)
                    .size(48.dp)
            )
            Text(
                text = stringResource(R.string.unknown_error_title),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 12.dp)
                    .padding(horizontal = 16.dp)
            )
            ExpandableCard(
                icon = Icons.Outlined.PermDeviceInformation,
                title = stringResource(id = R.string.device_info),
                subtitle = stringResource(id = R.string.device_info_subtitle),
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = versionReport,
                    style = MaterialTheme.typography.bodyMedium.copy(fontFamily = FontFamily.Monospace),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                        .fillMaxWidth()
                )
            }

            HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp))
            Text(
                text = log,
                style = MaterialTheme.typography.bodyMedium.copy(fontFamily = FontFamily.Monospace),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }
    }
}
