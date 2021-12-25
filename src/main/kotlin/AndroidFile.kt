import se.vidstige.jadb.JadbDevice
import se.vidstige.jadb.RemoteFile
import java.io.File

class AndroidFile private constructor(private val device: JadbDevice, val name: String, private val path: String) {

  fun delete() {
    device.execute("rm -rf", path)
  }

  fun copyTo(file: File) {
    device.pull(RemoteFile(path), file)
  }

  fun moveTo(file: File) {
    copyTo(file)
    delete()
  }

  fun listNested(): List<AndroidFile> {
    return device.list(path).map { nested ->
      AndroidFile(device, nested.path, "$path/${nested.path}")
    }
  }

  fun filterNested(filter: AndroidFile.() -> Boolean): List<AndroidFile> {
    return listNested().filter(filter)
  }

  override fun toString(): String {
    return path
  }

  companion object {

    fun JadbDevice.listUserFiles(): List<AndroidFile> {
      return list("/sdcard").map { AndroidFile(this, it.path, "/sdcard/${it.path}") }
    }
  }
}