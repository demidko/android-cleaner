# jadb-cleaner

Jadb-cleaner is a simple utility to clean up your Android device. The main feature is the automatic backup of possibly
useful files.

## Download

* [Windows version]()
* [macOS version]()
* [Linux version]()

## Usage

1. Turn on [USB debugging](https://developer.android.com/studio/debug/dev-options) on your device.
2. Connect your phone to your computer via USB.
3. Execute command
   ```shell
   ./jadb-cleaner
   ```

Enjoy the result! You can also configure backup directories, see help:

```shell
./jadb-cleaner -h
```

## Build

If you don't trust the binary utility, you can compile it yourself from source. You
need [GraalVM](https://www.graalvm.org/downloads/) installed.

1. Build jar utility
   ```shell
   ./gradlew clean build
    ```
2. Prepare the native-image tool by following
   the [official tutorial](https://www.graalvm.org/reference-manual/native-image).
3. Build native utility from jar
   ```shell
   native-image -jar build/libs/jadb-cleaner
   ```