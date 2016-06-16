#Android MVP开发模式最佳实践

写在前面：
    次项目讨论MVP开发模式在Android应用开发上的实践方式，旨在构建可拆解，低耦合的程序组织方式。
#一 前提条件

1. 你的工程的包结构应该满足以下结构：
![](https://github.com/guoxiaoxing/android-mvp-architecture-practice/blob/master/image/mvp_package_structure.png)
2. 你必须使用 Dagger 2 作为依赖注入，AppCompat用作注释和基类。

＃二 使用方法

1. 生成基础模版
首先，在包的根目录使用MVP Boilerplate创建基本的结构。这个操作对一个项目只需执行一次：
![](https://github.com/guoxiaoxing/android-mvp-architecture-practice/blob/master/image/create_boilerplate.png)
它将生成一个App类（Application），用于注入的ActivityScope, FragmentScope, AppModule和AppComponent，以及BaseActivity, BaseFragment, BasePresenter 和BaseInteractor。 
>一定记得在你的manifest中把生成的App作为你的Application！

2. 创建第一个activity
然后你可以使用 MVP Activity创建一个新的 MVP Activity，它将创建：

一个 Activity

一个Activity的布局

用于Dagger 2注入的一个Component和一个 Module 

一个Activity的View  interface

一个Presenter interface以及默认的实现类

一个Interactor以及model的默认实现

>从包的根路径去创建非常重要，否则将在子路径下重复生成整改MVP结构，这当然不是你想要的。



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

#Thanks
[android-architecture](https://github.com/googlesamples/android-architecture) - A collection of samples to discuss and showcase different architectural tools and patterns for Android apps.
[Android-Studio-MVP-template](https://github.com/benoitletondor/Android-Studio-MVP-template) - Android MVP template for Android Studio
