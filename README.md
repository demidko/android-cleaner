# Android Cleaner

Android Cleaner is a simple utility to clean up your Android device. The main feature is the automatic backup of
possibly useful files.

## Download

* [Windows version]()
* [macOS version]()
* [Linux version]()

## Usage

[USB debugging](https://developer.android.com/studio/debug/dev-options) must be enabled on your device.

1. Connect your phone to your computer via USB.
2. Execute command in shell:
   ```shell
   ./android-cleaner
   ```
   Enjoy the result 🙂

## Build

You can build the utility yourself from the source code. If you are using Linux or macOS you need LLVM installed. If you
are using Windows, you need Visual Studio installed and configure [`windowsVsVarsPath`](build.gradle.kts). Then, execute
command in cloned repository:

```shell
./gradlew clean build
```
