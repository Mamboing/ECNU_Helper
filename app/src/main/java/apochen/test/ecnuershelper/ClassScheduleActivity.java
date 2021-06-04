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
    private static final String tag = "ClassScheduleActivity";
    private static ArrayList<ClassData> classList;
    private GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_schedule);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }

        mainGrid = findViewById(R.id.main_class_gridLayout);

        if (classList == null)
            getClassData();

        addClassBlock();
    }

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

                    Log.d(tag, "Add one count in 'if' sentence");
                }
                else {
                    View childView = new TextView(this);

                    GridLayout.Spec rowSpec = GridLayout.spec(j, 1);
                    GridLayout.Spec columnSpec = GridLayout.spec(i + 1, 1, 1f);
                    GridLayout.LayoutParams gridParams = new GridLayout.LayoutParams(rowSpec, columnSpec);
                    gridParams.width = 0;
                    gridParams.height = GridLayout.LayoutParams.WRAP_CONTENT;
                    gridParams.setGravity(Gravity.FILL);

                    childView.setBackgroundColor(getResources().getColor(R.color.transparent, null));
                    mainGrid.addView(childView, gridParams);
                    j += 1;

                    Log.d(tag, "Add one count in 'else' sentence");
                }
            }
        }
    }

    private void getClassData() {
        classList = new ArrayList<>();
        classList.add(new ClassData("数据库系统及其应用", "教书院113", 1,
                 3, 4, 1, 17));
        classList.add(new ClassData("软件工程实践", "教书院419", 1,
                 3, 4, 1, 17));
        classList.add(new ClassData("网络安全数学", "教书院323", 3,
                3, 4, 1, 17));
        classList.add(new ClassData("数字图像处理","教书院219", 2,
                3, 4, 1, 17));
        classList.add(new ClassData("毛泽东思想和中国特色社会主义理论体系概论", "教书院316",
                4, 9, 11, 1, 17));
        classList.add(new ClassData("剑桥商务英语", "教书院210", 5,
                1, 2, 1, 16));
        classList.add(new ClassData("移动应用开发", "教书院219", 5,
                3, 4, 1, 17));
    }
}