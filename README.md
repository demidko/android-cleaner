# jadb-cleaner

Jadb-cleaner is a simple utility to clean up your Android. The main feature is the automatic backup of possibly useful
files.

## Download

* [macOS version]()
* [Windows version]()
* [Linux version]()

## Usage

1. Turn on [developer features](https://developer.android.com/studio/debug/dev-options) on your phone.
2. Connect your phone to your computer via usb.
3. Execute
   ```shell
   ./jadb-cleaner
   ```
4. Enjoy the result!

## Build with Java

### Build jar utility

Execute `./gradlew clean build`. Your jar will be located at `./build/libs` with `-all.jar` postfix. Now you can run:

```shell
java -jar jadb-cleaner-all.jar
```

### Build native utility

## Or, build with Docker

Execute `docker build . -t service`. Your image will be located at `docker images -a`. Now you can run:

```shell
docker run -v `pwd`:`pwd` -w `pwd` -it --rm jadb-cleaner
```
