#Android MVP开发模式最佳实践

写在前面：
    次项目讨论MVP开发模式在Android应用开发上的实践方式，旨在构建可拆解，低耦合的程序组织方式。
#一 前提条件
1. 你的工程的包结构应该满足以下结构：

![](https://github.com/guoxiaoxing/android-mvp-architecture-practice/blob/master/image/mvp_package_structure.png)  
2. 你必须使用 Dagger 2 作为依赖注入，AppCompat用作注释和基类。

#二 使用方法
1. 生成基础模版
首先，在包的根目录使用MVP Boilerplate创建基本的结构。这个操作对一个项目只需执行一次：
![](https://github.com/guoxiaoxing/android-mvp-architecture-practice/blob/master/image/create_boilerplate.png)
它将生成一个App类（Application），用于注入的ActivityScope, FragmentScope, AppModule和AppComponent，以及BaseActivity, BaseFragment, BasePresenter 和BaseInteractor。 
**注意**：一定记得在你的manifest中把生成的App作为你的Application！

2. 创建第一个Activity
然后你可以使用 MVP Activity创建一个新的 MVP Activity，它将创建：

- 一个 Activity
- 一个Activity的布局
- 用于Dagger 2注入的一个Component和一个 Module 
- 一个Activity的View  interface
- 一个Presenter interface以及默认的实现类
- 一个Interactor以及model的默认实现

**注意**：从包的根路径去创建非常重要，否则将在子路径下重复生成整改MVP结构，这当然不是你想要的。

#Thanks
[android-architecture](https://github.com/googlesamples/android-architecture) - A collection of samples to discuss and showcase different architectural tools and patterns for Android apps.  
[Android-Studio-MVP-template](https://github.com/benoitletondor/Android-Studio-MVP-template) - Android MVP template for Android Studio
