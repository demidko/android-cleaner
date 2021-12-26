import org.apache.commons.cli.*
import java.io.File

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
    val documentsBackup = arguments.getOptionValue("d", "Android Documents")
    val photosBackup = arguments.getOptionValue("p", "Android Photos")
    val musicBackup = arguments.getOptionValue("m", "Android Music")

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


