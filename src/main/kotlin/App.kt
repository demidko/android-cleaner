import AndroidFile.Companion.sdcard
import org.apache.commons.cli.HelpFormatter
import org.apache.commons.cli.Option
import org.apache.commons.cli.Options
import org.apache.commons.cli.ParseException
import se.vidstige.jadb.JadbConnection

fun main(args: Array<String>) {
  val params = Options()
  for (name in listOf("documents", "photos", "music")) params.addOption(
    Option.builder(name.first().toString())
      .longOpt("backup-$name-to")
      .hasArg()
      .argName("folder")
      .desc("backup $name to custom folder")
      .build()
  )
  try {
    val cacheDirectories = setOf(
      Regex("/sdcard/Adnroid/data/.*/cache")
    )
    val sdcard = JadbConnection().anyDevice.sdcard
    val cleanup = Modifier(cacheDirectories) {
      println("""Delete "$this"""")
      delete()
    }
    cleanup.walk(sdcard)

    //val arguments = DefaultParser().parse(params, args)

    /*val documentDestination = arguments.getOptionValue("d", "Android Documents")
    // todo возможно каждый Backup здесь стоит заменить просто на File?
    val documentsBackup = Backup(documentDestination)
    val photosDestination = arguments.getOptionValue("p", "Android Photos")
    val photosBackup = Backup(photosDestination)
    val musicDestination = arguments.getOptionValue("m", "Android Music")
    val musicBackup = Backup(musicDestination)*/
  } catch (e: ParseException) {
    HelpFormatter().printHelp(
      "jadb-cleaner",
      "example: jadb-cleaner -p MyAndroidPhotosBackup",
      params,
      "source code: https://github.com/demidko/jadb-cleaner",
      true
    )
  }
}


