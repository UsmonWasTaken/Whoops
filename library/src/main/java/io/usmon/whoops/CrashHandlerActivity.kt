package io.usmon.whoops

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import io.usmon.whoops.internal.CrashReportContent
import java.io.File

public class CrashHandlerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { v, insets ->
            v.setPadding(0, 0, 0, 0)
            insets
        }
        val versionReport: String = intent.getStringExtra("version_report").toString()
        val logfilePath: String = intent.getStringExtra("logfile_path").toString()
        val reportUrl: String? = intent.getStringExtra("reportUrl")

        setContent {
            var log by rememberSaveable(key = "log") {
                mutableStateOf("")
            }

            LaunchedEffect(true) {
                val logFile = File(logfilePath)
                log = logFile.readText()
            }

            CrashReportContent(
                log = log,
                versionReport = versionReport,
                reportUrl = reportUrl,
                onExit = this::finishAffinity
            )
        }
    }
}
