class Modifier(private val files: Set<Regex>, private val func: AndroidFile.() -> Unit) {

  fun walk(file: AndroidFile) {
    if (match(file)) {
      func(file)
    } else {
      file.nested().forEach(::walk)
    }
  }

  private fun match(file: AndroidFile): Boolean {
    return files.any { regex ->
      regex.containsMatchIn(file.toString())
    }
  }
}