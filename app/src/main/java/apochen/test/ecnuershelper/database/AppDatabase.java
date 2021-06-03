package apochen.test.ecnuershelper.database;

import com.raizlabs.android.dbflow.annotation.Database;

/** 数据库定义 **/
@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase {

    public static final String NAME = "ECNUersHelper";

    public static final int VERSION = 1;
}
