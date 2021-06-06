package apochen.test.ecnuershelper;

import android.graphics.Color;
import java.util.HashMap;
import java.util.Map;

public class ClassData {
    private String courseName;     // 课程名
    private String classRoom;       // 教室地点
    private int weekdayIndex;       // 对应周次
    private int startClassIndex, endClassIndex;     // 开始结束节次
    private int startWeek, endWeek;     // 开始结束周数
    private Integer bgColor;        // 课程块背景颜色

    enum BlockColor {
        LightPink, Flesh, Orange, GreyGreen, LightGreen, LightYellow, GreyBlue, FleshPink, Red, LightWhite
    }

    /* 所有课程块颜色支持 */
    static final Map<BlockColor, Integer> colorMap = new HashMap<BlockColor, Integer>() {{
        put(BlockColor.LightPink, Color.rgb(254, 67, 101));
        put(BlockColor.Flesh, Color.rgb(249, 205, 173));
        put(BlockColor.Orange, Color.rgb(248, 147, 29));
        put(BlockColor.GreyGreen, Color.rgb(137, 190, 178));
        put(BlockColor.LightGreen, Color.rgb(107, 194, 53));
        put(BlockColor.LightYellow, Color.rgb(250, 227, 113));
        put(BlockColor.GreyBlue, Color.rgb(137, 157, 192));
        put(BlockColor.FleshPink, Color.rgb(252, 157, 154));
        put(BlockColor.Red, Color.rgb(171, 92, 37));
        put(BlockColor.LightWhite, Color.rgb(255, 245, 247));
    }};

    ClassData(String courseName, String classRoom, int weekdayIndex, int startClassIndex, int endClassIndex,
              int startWeek, int endWeek) {
        this.courseName = courseName;
        this.classRoom = classRoom;
        this.weekdayIndex = weekdayIndex;
        this.startClassIndex = startClassIndex;
        this.endClassIndex = endClassIndex;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        // 随机获取课程块的颜色
        this.bgColor = colorMap.get(BlockColor.values()[(int) (Math.random() * BlockColor.values().length)]);
    }

    String getCourseName() { return courseName; }

    int getWeekdayIndex() { return weekdayIndex; }

    int getStartClassIndex() { return startClassIndex; }

    int getClassRange() { return endClassIndex - startClassIndex + 1; }

    Integer getBgColor() { return bgColor; }

    String classInfo() {
        /* 目前特殊情况的课程，诸如周数不连续的暂不支持显示 */
        return courseName + "\n" + classRoom + "\n" + startWeek + "~" + endWeek + "周";
    }

}
