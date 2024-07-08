## Whoops: Android Global Crash Handler

This library simplifies crash handling in your Android applications, making debugging and user
experience smoother. It acts as a global uncaught exception handler, catching unexpected crashes
that occur during runtime. When a crash happens, Whoops displays a user-friendly crash report
dialog, providing details about the exception and offering options for the user to report the issue.

**Key Features:**
* **Robust Crash Handling:** Catches uncaught exceptions seamlessly, preventing app crashes.
* **User-Friendly Reporting:** Presents a clear and informative crash report.
* **Exception Details:** Displays detailed crash information like stack trace, exception type, and message.
* **Reporting Options:** Allows users to easily report crashes (e.g., email, third-party services).

**Quick Setup:**

1. **Add the Jitpack Repository:**

   Jitpack is a third-party repository hosting. To use it, add the Jitpack repository URL to
   your `settings.gradle.kts` file:

   ```kotlin
   dependencyResolutionManagement {
       repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
       repositories {
           mavenCentral()
           maven("https://jitpack.io")
           // ...
       }
   }
   ```

   **What's Jitpack?** Jitpack is a convenient way to use libraries not yet available in the
   official Maven repository.

2. **Add Whoops as a Dependency:**

   Add the following dependency to your `app/build.gradle` file:

   ```kotlin
   dependencies {
       // ...
       implementation("com.github.UsmonWasTaken:Whoops:1.0.0-alpha1")
   }
   ```

3. **Setup the Crash Handler:**

   Create a class extending `Application` and register it in your `AndroidManifest.xml`. This class
   will initialize Whoops for crash handling.

   ```kotlin
   class MyApplication : Application() {
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
   ```

   **Note:** Replace `MyApplication` with your actual application class name.
