import AndroidFile.Companion.getAndroidSdcard
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.file
import java.io.File

object AndroidCleaner : CliktCommand(
  "Android Cleaner is a simple utility to clean up your Android device.",
  "S.D.G 2022"
) {
  private val backupImagesTo by option().file().default(File("Android Images"))

  private val backupDocsTo by option().file().default(File("Android Docs"))

  private val backupAudioTo by option().file().default(File("Android Audio"))

  private val backupVideoTo by option().file().default(File("Android Video"))

  private val androidSdcard = getAndroidSdcard()

  override fun run() {

  }
}