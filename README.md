# jadb-cleaner

Jadb-cleaner is a simple utility to clean up your Android device. The main feature is the automatic backup of possibly
useful files.

## Download

* [Windows version]()
* [macOS version]()
* [Linux version]()

## Usage

[USB debugging](https://developer.android.com/studio/debug/dev-options) must be enabled on your device.

1. Connect your phone to your computer via USB.
2. Execute command in shell:
   ```shell
   ./jadb-cleaner
   ```
   Enjoy the result 🙂

## Build

You need [GraalVM](https://www.graalvm.org/downloads/)
and [native-image](https://www.graalvm.org/reference-manual/native-image) installed.

1. Build jar:
   ```shell
   ./gradlew clean build
    ```
2. Build utility:
   ```shell
   ./native-image -jar build/libs/jadb-cleaner
   ```