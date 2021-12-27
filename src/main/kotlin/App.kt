import AndroidFile.Companion.sdcard
import org.apache.commons.cli.*
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
    val arguments = DefaultParser().parse(params, args)

    val cache = Regex("/sdcard/Adnroid/data/.*/cache")

    val documentDestination = arguments.getOptionValue("d", "Android Documents")
    // todo возможно каждый Backup здесь стоит заменить просто на File?
    val documentsBackup = Backup(documentDestination)
    val photosDestination = arguments.getOptionValue("p", "Android Photos")
    val photosBackup = Backup(photosDestination)
    val musicDestination = arguments.getOptionValue("m", "Android Music")
    val musicBackup = Backup(musicDestination)
    val adb = JadbConnection()
    val sdcard = adb.anyDevice.sdcard


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


