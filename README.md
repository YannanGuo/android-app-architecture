#Android MVP开发模式最佳实践

写在前面：
    次项目拓展与Google关于Android应用开发架构的建议[android-architecture](https://github.com/googlesamples/android-architecture)。讨论MVP
开发模式在Android应用开发上的实践。

##一 MVP框架

![](https://github.com/guoxiaoxing/android-mvp-architecture-pratice/blob/master/image/mvp.png)

view - UI显示层
view 层主要负责：

提供UI交互
在presenter的控制下修改UI。
将业务事件交由presenter处理。
注意. View层不存储数据，不与Model层交互。
presenter - 逻辑处理层
presenter 层主要负责：

对UI的各种业务事件进行相应处理。也许是与Model层交互，也许自己进行一些计算，也许控制后台Task，Servic
对各种订阅事件进行响应，修改UI。
临时存储页面相关数据。
注意. Presenter内不出现View引用。
model - 数据层
model层主要负责：

从网络，数据库，文件，传感器，第三方等数据源读写数据。
对外部的数据类型进行解析转换为APP内部数据交由上层处理。
对数据的临时存储,管理，协调上层数据请求。

