package apochen.test.ecnuershelper.database;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

public class MyApplication extends Application {

    /** 数据库初始化 **/
    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
        createUser();
    }

    /** 创建用户 **/
    private void createUser() {
        User user = new User();
        user.setStudentId("10195101418");
        user.setStudentName("张三");
        user.save();
    }

}
