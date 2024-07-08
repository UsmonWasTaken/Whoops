package io.usmon.whoops.example

import android.app.Application
import io.usmon.whoops.CrashHandler.setupCrashHandler

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        // Setup the crash handler
        setupCrashHandler {
            androidVersion = true
            deviceInfo = true
            supportedABIs = true
            reportUrl = "https://github.com/UsmonWasTaken/Whoops/issues/new"
        }
    }
}