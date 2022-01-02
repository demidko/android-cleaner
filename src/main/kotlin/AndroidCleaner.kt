import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.file
import java.io.File

object AndroidCleaner : CliktCommand() {

  val backupPhotosTo by option().file().default(File("Android Photos"))

  val backupDocsTo by option().file().default(File("Android Docs"))

  val backupMusicTo by option().file().default(File("Android Music"))

  override fun run() {

  }

  fun findMusic() {

  }


}