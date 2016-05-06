#Android MVP开发模式最佳实践

写在前面：
    次项目拓展与Google关于Android应用开发架构的建议[android-architecture](https://github.com/googlesamples/android-architecture)。讨论MVP
开发模式在Android应用开发上的实践。

##一 MVP框架原理

![](https://github.com/guoxiaoxing/android-mvp-architecture-pratice/blob/master/image/mvp.png)

Presenter 是Model和View的中间衔接层，一个标准的Presenter中应该至少包含一个Model和一个View。
在MVP模式中，View是不允许与Model交互的，View只是负责展示数据，是彻底的哑View。当View需要更新数据时，
需要通过Presenter来操作Model，Model获取到数据后再通过Presenter来更新View。
Presenter不直接操作数据（更新数据状态），需要调用Model操作数据（更新数据状态）

###1.1 View层
显示层，主要负责：
1. 提供UI交互
2. 在presenter的控制下修改UI。
3. 将业务事件交由presenter处理。
注意：View层不存储数据，不与Model层交互。
###1.2 Presenter层
逻辑处理层，主要负责：
1. 对UI的各种业务事件进行相应处理。也许是与Model层交互，也许自己进行一些计算，也许控制后台Task，Servic
2. 对各种订阅事件进行响应，修改UI。
3. 临时存储页面相关数据。
注意：Presenter内不出现View引用。
###1.3 Model层
数据层，主要负责：
1. 从网络，数据库，文件，传感器，第三方等数据源读写数据。
2. 对外部的数据类型进行解析转换为APP内部数据交由上层处理。
3. 对数据的临时存储,管理，协调上层数据请求。
注意：Model层不同于Java的Bean类，它包含类业务逻辑和数据的处理，它会把数据处理程POJO对象送往Presenter层。

##二 MVP最佳实现
###2.1 Activity生命周期

Activity是一个上帝类，其实不适合作为View。我们可以在顶级父类中将Activity的生命周期在Presenter中实现一遍，然后生命周期有关的业务逻辑直接由Presenter来实现。
