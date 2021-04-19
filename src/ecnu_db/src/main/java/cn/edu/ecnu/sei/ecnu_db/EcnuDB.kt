package cn.edu.ecnu.sei.ecnu_db

@Suppress("SpellCheckingInspection")
private object URL {
    private const val CAS = "portal1.ecnu.edu.cn/cas"
    private const val JW = "applicationnewjw.ecnu.edu.cn"

    const val PORTAL = "https://$CAS/login?service=http%3A%2F%2F$JW%2Feams%2Fhome.action"
    const val TABLE = "http://$JW/eams/courseTableForStd!courseTable.action"
    const val IDS = "http://$JW/eams/courseTableForStd!index.action"
    const val CAPTCHA = "https://$CAS/code"

    val HEADERS = mapOf(
        "User-Agent" to "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36",
        "Refer" to "$PORTAL%3Bjs"
    )
}

object EcnuDB {

}