import java.io.File

class Backup(private val storage: File) {

  constructor(path: String) : this(File(path))

  fun save(file: AndroidFile) {
    file.copyToDirectory(storage)
  }
}