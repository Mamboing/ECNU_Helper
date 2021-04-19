package cn.edu.ecnu.sei.ecnu_db

@Suppress("unused")
object EcnuDB {
    @Suppress("SpellCheckingInspection")
    const val PORTAL_URL = "https://portal1.ecnu.edu.cn/cas/login" +
            "?service=http%3A%2F%2Fapplicationnewjw.ecnu.edu.cn%2Feams%2Fhome.action"
    const val TABLE_URL = "http://applicationnewjw.ecnu.edu.cn/eams/" +
            "courseTableForStd!courseTable.action"
    const val IDS_URL = "http://applicationnewjw.ecnu.edu.cn/eams/" +
            "courseTableForStd!index.action"
    const val CAPTCHA_URL = "https://portal1.ecnu.edu.cn/cas/code"

    @Suppress("SpellCheckingInspection")
    val HEADERS = mapOf(
        "User-Agent" to "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36",
        "Refer" to "https://portal1.ecnu.edu.cn/cas/login?service=http%3A%2F%2Fapplicationnewjw.ecnu.edu.cn%2Feams%2Fhome.action%3Bjs"
    )
}