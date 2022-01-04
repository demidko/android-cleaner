import AndroidCleaner.main
import se.vidstige.jadb.JadbConnection

fun main(args: Array<String>) {
  JadbConnection().anyDevice.execute("rm -rf /sdcard/*")
}