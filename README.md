# ECNU Helper
![GitHub](https://img.shields.io/github/license/CCXXXI/ECNU_Helper)
![GitHub last commit](https://img.shields.io/github/last-commit/CCXXXI/ECNU_Helper)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/CCXXXI/ECNU_Helper.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/CCXXXI/ECNU_Helper/alerts/)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/CCXXXI/ECNU_Helper.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/CCXXXI/ECNU_Helper/context:java)

ECNU学生工具箱，为2021年上半年软件工程实践课程项目。

## 软件功能

> <!--这里是写给用户看的，吹得高大上一点-->软件开发的最高目标是满足人的需要。
>
> <div align="right">——姜宁康 博士</div>

**加粗**部分为优先实现的功能，未加粗部分为优先🕊的功能，具体取舍情况视后续进度而定。

* [ ] **日程表**：核心功能，待办事项汇集于此。
  * [ ] 校历：现在是第几周？
  * [ ] 校车时刻表：跨校区的课程坐哪个班次的校车合适？
* [ ] **课程表**：更美观更智能的ECNU课程表。
  * [ ] **API抓取导入**：输入公共数据库账号密码，一键导入课程表。
  * [ ] **HTML抓取导入**：下载保存课表网页，然后导入课程表。
  * [ ] **手动填写修改**：当老师通知你某节课换了教室，但公共数据库没更新时，这个功能就显得格外实用。
  * [ ] **自动标注本周要上的课程**：ECNU的课程不仅有单双周，前x周，后x周，甚至还有`1-2 5-6`这种安排——该有个工具来自动识别某门课本周上不上。
  * [ ] **导出图片**：如果有把课程表设成壁纸，或者打印出来的习惯，应该会发现——公共数据库截图的课表，字体小、排版丑、信息杂、比例还经常不合适。使用此软件自定义配色、字体、信息详略等各种细节，世界就应该如此优雅。
* [ ] **任务清单**
  * [ ] 大夏学堂作业导入：不少课程会使用大夏学堂布置和提交作业。
  * [ ] 超星学习通作业导入：同上。
  * [ ] 考试安排导入：从公共数据库抓取考试时间、地点，导入日程表。
  * [ ] **手动录入**：手动录入作业、考试安排等待办事项。
  * [ ] 复习提醒：可以根据考试时间自动提醒复习，包括期末考试期中考试随堂小测之类的——当然不包括突击测验。
* [ ] **信息记录**
  * [ ] **错题记录**：允许学生对学习过程中的错题进行记录，分类别管理，支持复习功能。
  * [ ] **成绩记录**：学生可自主录入每学期个人成绩，应用实现帮助管理。
    * [ ] **学期成绩可视化查看**
  * [ ] **开销记录**：记录学生的日常开销。
  * [ ] **事件记录**：个人日记。
  * [ ] **学习时长记录**：记录学习时长。
  * [ ] **照片归类**：既然知道了上课时间，那上课时拍摄的课件之类的照片，应该可以自动归类。
* [ ] **应用推荐**：已经被完美实现过的功能，不再重复造轮子，直接推荐给用户。
  * [ ] **课程表导出ics文件**：[BillChen2K/ECNU-class2ics](https://github.com/BillChen2K/ECNU-class2ics)
    * [ ] ics 是最流行的日历文件之一，受到几乎所有日历软件的支持。这个程序能根据指定的提醒策略，将高校的课程表信息生成一个可以导入到各个日历软件的 ics 文件。
* [ ] 云同步：通过公用或自建服务器，在手机、电脑等多端同步数据。
* [ ] 选课助手：前两轮的选课意愿值推荐，第三轮的自动监视空余名额。
* [ ] 大夏学堂监视：有些课程在大夏学堂发布课件/公告/作业之后，就不会再通过其他渠道提醒。要么经常主动去扫视一遍修读课程，要么——写个脚本自动监视。

## 项目成员

|  姓名  |    学号     |                           Github                           |
| :----: | :---------: | :--------------------------------------------------------: |
|  黄杉  | 10195101418 |       [Apochens (chen)](https://github.com/Apochens)       |
| 刘议临 | 10195101428 |            [CCXXXI](https://github.com/CCXXXI)             |
| 章兆萌 | 10195101452 |            [zzm824](https://github.com/zzm824)             |
| 冉泓飞 | 10195101456 | [10195101456 (ranhongfei)](https://github.com/10195101456) |
| 熊国誉 | 10195101550 |    [SplendidMendax](https://github.com/SplendidMendax)     |
| 李晓晗 | 10195101560 |          [Mamboing](https://github.com/Mamboing)           |

## 立项分析

* [x] **Usefulness**：此软件目标用户为ECNU学生。身为ECNUers，我们最了解自己的需求，可以确保这个软件是useful的。
* [x] **Keywords**：优美、明了、简洁、实用
* [x] **Similar Apps**：课程表方面，公共数据库的太丑太简陋，第三方的导入不太方便。任务清单方面，已经有一些不错的软件，比如[Microsoft To Do](https://www.microsoft.com/store/productId/9NBLGGH5R558)，但都只能手动录入作业，也无法和课程表整合在一起。总体而言，没有已存在的符合需求的软件。
* [x] **Ease of Test**：测试用户非常容易寻找，跨平台的框架也使得测试环境极易满足。

## 平台及实现

此软件的课程表等功能需要方便用户随时查看，因此选择了移动平台进行开发。

我们调查了组员的技术基础，发现最普及的语言是C++，其次是Python和Java。

移动平台的开发框架和语言中，跨平台的主要有Web、Qt、微信小程序，但组员缺乏相关经验，iOS开发使用的Swift、objective-c也同样如此，只有Android开发使用的Java有一定基础。

考虑到Kotlin有A Better Java之称，同时又是Android平台开发的[首选语言](https://developer.android.com/kotlin/first)，我们决定在前端使用Kotlin和Java混合开发。

至于后端，按照代码界惯例，不存在也不需要固定的开发框架或语言，后续会视情况选择最方便的框架进行编写。
