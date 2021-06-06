package apochen.test.ecnuershelper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class ClassScheduleActivity extends AppCompatActivity {
    // 声明并赋值Debug和Error检测用标签
    private static final String tag = "ClassScheduleActivity";
    // ArrayList用于存储课程数据信息
    private static ArrayList<ClassData> classList;
    // 整体课表结构布局GridLayout
    private GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_schedule);

        /* 隐藏自带的标题栏 */
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }

        mainGrid = findViewById(R.id.main_class_gridLayout);

        /* ArrayList获取课程数据 */
        if (classList == null)
            getClassData();

        /* 添加课程块 */
        addClassBlock();
    }

    /* 从ArrayList中导入课程块到课程表中 */
    private void addClassBlock() {
        int ind = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 11; ) {
                if (ind < classList.size() && classList.get(ind).getWeekdayIndex() == i + 1 &&
                        classList.get(ind).getStartClassIndex() == j + 1) {
                    ClassData tmpClass = classList.get(ind);
                    TextView classText = new TextView(new ContextThemeWrapper(this, R.style.ClassTextView));
                    classText.setText(tmpClass.classInfo());
                    classText.setLayoutParams(new FrameLayout.LayoutParams(
                            FrameLayout.LayoutParams.WRAP_CONTENT,
                            FrameLayout.LayoutParams.WRAP_CONTENT,
                            Gravity.CENTER
                    ));

                    /* 以CardView作为课程块布局 */
                    CardView classCard = new CardView(new ContextThemeWrapper(this, R.style.ClassCardView));
                    classCard.setCardBackgroundColor(tmpClass.getBgColor());
                    classCard.addView(classText);
                    classCard.setRadius(20);

                    Log.d(tag, "Add a CardView of a class completed!");

                    GridLayout.Spec rowSpec = GridLayout.spec(j, tmpClass.getClassRange());
                    GridLayout.Spec columnSpec = GridLayout.spec(i + 1, 1f);
                    GridLayout.LayoutParams gridParams = new GridLayout.LayoutParams(rowSpec, columnSpec);
                    gridParams.width = 0;
                    gridParams.height = 0;
                    gridParams.setGravity(Gravity.FILL);

                    mainGrid.addView(classCard, gridParams);
                    j += tmpClass.getClassRange();
                    ind++;

                    Log.d(tag, "'if' sentence of addClassBlock() has executed once successfully!");
                }
                else {
                    View childView = new TextView(this);

                    GridLayout.Spec rowSpec = GridLayout.spec(j, 1);
                    GridLayout.Spec columnSpec = GridLayout.spec(i + 1, 1, 1f);
                    GridLayout.LayoutParams gridParams = new GridLayout.LayoutParams(rowSpec, columnSpec);
                    gridParams.width = 0;
                    gridParams.height = GridLayout.LayoutParams.WRAP_CONTENT;
                    gridParams.setGravity(Gravity.FILL);

                    /* 将未放置课程块的View的背景颜色设为透明 */
                    childView.setBackgroundColor(getResources().getColor(R.color.transparent, null));
                    mainGrid.addView(childView, gridParams);
                    j += 1;

                    Log.d(tag, "'else' sentence of addClassBlock() has executed once successfully!");
                }
            }
        }
    }

    /* 导入课程数据到ArrayList中 */
    private void getClassData() {
        classList = new ArrayList<>();

        /* 由于导入逻辑的原因，导入数据需要从左至右，从上至下导入，否则会出现部分课程块不显示的问题
        * 下面为示例课程数据导入 */
        classList.add(new ClassData("数据库系统及其应用", "教书院113", 1,
                 3, 4, 1, 17));
        classList.add(new ClassData("软件工程实践", "教书院419", 1,
                 5, 6, 1, 17));
        classList.add(new ClassData("数字图像处理","教书院219", 2,
                3, 4, 1, 17));
        classList.add(new ClassData("网络安全数学", "教书院323", 3,
                3, 4, 1, 17));
        classList.add(new ClassData("毛泽东思想和中国特色社会主义理论体系概论", "教书院316",
                4, 9, 11, 1, 17));
        classList.add(new ClassData("剑桥商务英语", "教书院210", 5,
                1, 2, 1, 16));
        classList.add(new ClassData("移动应用开发", "教书院219", 5,
                3, 4, 1, 17));

        for (int i = 0; i < classList.size(); i++)
        {
            Log.d(tag, "Add class data of " + classList.get(i).getCourseName() + " completed!");
        }
    }
}