import AndroidFile.Companion.listUserFiles
import se.vidstige.jadb.JadbConnection
import se.vidstige.jadb.JadbDevice


fun main() {
  val files = JadbConnection().anyDevice.listUserFiles()
  println(files.size)
}

fun JadbDevice.deleteAppsCache() {

}
