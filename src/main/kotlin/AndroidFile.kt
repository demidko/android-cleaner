import se.vidstige.jadb.JadbDevice
import se.vidstige.jadb.RemoteFile
import java.io.File

class AndroidFile private constructor(private val device: JadbDevice, private val name: String, private val path: String) {

  fun delete() {
    device.execute("rm -rf", path)
  }

  fun copyToDirectory(d: File) {
    val source = RemoteFile(path)
    val destination = File(d, name)
    device.pull(source, destination)
  }

  fun nested(): List<AndroidFile> {
    val files = device.list(path).filter { file ->
      file.path != "." && file.path != ".."
    }
    return files.map { file ->
      AndroidFile(device, file.path, "$path/${file.path}")
    }
  }

  override fun toString(): String {
    return path
  }

  companion object {
    val JadbDevice.sdcard get() = AndroidFile(this, "sdcard", "/sdcard")
  }
}