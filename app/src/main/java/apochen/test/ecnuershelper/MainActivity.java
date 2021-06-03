package apochen.test.ecnuershelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Select;

import apochen.test.ecnuershelper.database.User;
import apochen.test.ecnuershelper.database.User$Table;

public class MainActivity extends AppCompatActivity {

    private ImageButton mUserPortrait;
    private TextView mUSerName;
    private TextView mUserId;
    private TextView mStudyTimeInfo;

    private Button mHomeworkPlan;
    private Button mProblems;
    private Button mTestSchedule;
    private Button mScoresRecord;
    private Button mFinanceRecord;
    private Button mDiary;
    private Button mClassSchedule;
    private Button mStartStudy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUSerName = (TextView) findViewById(R.id.user_name);
        mUserId = (TextView) findViewById(R.id.user_id);
        setNameAndId(getUser());


        // 作业计划
        mHomeworkPlan = (Button) findViewById(R.id.homework_plan);

        // 错题
        mProblems = (Button) findViewById(R.id.problems);
        mProblems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // 考试安排
        mTestSchedule = findViewById(R.id.test_schedule);

        // 成绩
        mScoresRecord = findViewById(R.id.scores_record);

        // 记账
        mFinanceRecord = findViewById(R.id.finance_record);

        // 日记
        mDiary = findViewById(R.id.diary);

        // 课程表
        mClassSchedule = findViewById(R.id.class_schedule);
        mClassSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ClassScheduleActivity.class));
            }
        });


    }

    // 从数据库中获取用户名称和学号
    private User getUser() {
        User user = new Select().from(User.class).querySingle();
        return user;
    }

    // 设置用户名和学号
    private void setNameAndId(User user) {
        mUSerName.setText(user.getStudentName());
        mUserId.setText(user.getStudentId());
    }
}

