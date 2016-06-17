#MVP框架最佳实践之依赖注入

[Dagger2项目主页](http://google.github.io/dagger/)

>Class A中用到了Class B的对象b，一般情况下，需要在A的代码中显式的new一个B的对象。采用依赖注入技术之后，A的代码只需要定义
一个私有的B对象，不需要直接new来获得这个对象，而是通过相关的容器控制程序来将B对象在外部new出来并注入到A类里的引用中。而具体
获取的方法、对象被获取时的状态由配置文件（如XML）来指定。

简单来说, 就是将对象的生产和使用给分开了。比如说有一个Car对象，当你要出行的时候就自己new一个Car对象，然后使用这个Car对象出行。
在这里你出行的时候Car就是你的依赖，没有这个Car就无法出行，所以就自己来创建这个Car。如果使用依赖注入了呢？创建和使用Car是分隔
开的，创建的地方不考虑使用，使用的时候也不用考虑来创建，只要说我需要一辆Car，Dagger2就会自动帮你创建好并让你使用。这就在一定程
度上解耦了程序，让你的模块更加地可以重用。

介绍完了依赖注入的概念, 我们再来看一下今天介绍的依赖注入的框架Dagger2。

#一 Dagger使用方法

##1.1 添加依赖

在整个项目的build.gradle中加入：
```
dependencies {
   // other classpath definitions here
   classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
}
```

在app/build.gradle中分别加入：
```
// add after applying plugin: 'com.android.application'  
apply plugin: 'com.neenbedankt.android-apt'
dependencies {
  // apt command comes from the android-apt plugin
  apt 'com.google.dagger:dagger-compiler:2.2'
  compile 'com.google.dagger:dagger:2.2'
  provided 'javax.annotation:jsr250-api:1.0'
}
```

**注意**: provided代表编译时需要的依赖，Dagger的编译器生成依赖关系的代码，并在编译时添加到IDE 的class path中，只参与编译，并不会打包到最终的apk中。
apt是由android-apt插件提供，它并不会添加这些类到class path中，这些类只用于注解解析，应当避免使用这些类。

##1.2 编写代码

下面我们通过一个实际的例子来阐述如何载代码中使用Dagger进行依赖注入

**举例**

我们先从一个最简单的开始写起, 全局Application的Context, 这也是我们使用最多的上下文对象, 通常我们都会提供一个它的全局引用, 如下所示:

```java

```

1 编写依赖

```java
package com.guoxiaoxing.mvp.injection;

import android.content.Context;
import android.support.annotation.NonNull;

import com.guoxiaoxing.mvp.MvpApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class AppModule {
    @NonNull
    private final MvpApplication mApp;

    public AppModule(@NonNull MvpApplication app) {
        mApp = app;
    }

    @Provides
    @Singleton
    public Context provideAppContext() {
        return mApp;
    }

    @Provides
    @Singleton
    public MvpApplication provideApp() {
        return mApp;
    }
}
```

我们使用@Provides注解告诉Dagger provideApp()这个方法是Application的实例的提供者。使用@Singleton注解告诉Dagger整个生命周期中只会被初始化一次。

2 编写组件

```java
package com.guoxiaoxing.mvp.injection;

import android.content.Context;

import com.guoxiaoxing.mvp.MvpApplication;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    Context getAppContext();

    MvpApplication getApp();
}
```

组件(Component)就是我们的注入类, 它将依赖注入到需要的地方。

3 初始化组件

```java
package com.guoxiaoxing.mvp;

import android.app.Application;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.guoxiaoxing.mvp.injection.AppComponent;
import com.guoxiaoxing.mvp.injection.AppModule;
import com.guoxiaoxing.mvp.injection.DaggerAppComponent;
public final class MvpApplication extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    @NonNull
    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
```

Dagger类会为@Component注解的类自动生成代码, 它会在类前面添加Dagger前缀(例如: DaggerAppComponent), 这个类会负责初始化依赖关系中的实例, 并为注解@Inject执行注入操作,
自动生成的如下所示:

```java
package com.guoxiaoxing.mvp.injection;

import android.content.Context;
import com.guoxiaoxing.mvp.MvpApplication;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private Provider<Context> provideAppContextProvider;

  private Provider<MvpApplication> provideAppProvider;

  private DaggerAppComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideAppContextProvider = AppModule_ProvideAppContextFactory.create(builder.appModule);

    this.provideAppProvider = AppModule_ProvideAppFactory.create(builder.appModule);
  }

  @Override
  public Context getAppContext() {
    return provideAppContextProvider.get();
  }

  @Override
  public MvpApplication getApp() {
    return provideAppProvider.get();
  }

  public static final class Builder {
    private AppModule appModule;

    private Builder() {}

    public AppComponent build() {
      if (appModule == null) {
        throw new IllegalStateException(AppModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerAppComponent(this);
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }
  }
}

```

4 使用组件  
在Activity中, 我们获取AppComponent再调用getApp()方法即可完成注入。
```java
    private void injectDependencies() {
        ((MvpApplication) getApplication()).getAppComponent().getApp();
    }
```


我们通常会在应用启动时会初始化各种组件, 网络组件, 缓存组件等, 如下所示:

```

```

Dagger2 通过注解来生成代码，定义不同的角色，主要的注解有：@Inject、@Module 、@Component 、@Provides 、@Scope 、@SubComponent 等。

- @Inject: 通常在需要依赖的地方使用这个注解。换句话说，你用它告诉Dagger这个类或者字段需要依赖注入。这样，Dagger就会构造一个这个类的实例并满足他们的依赖。
- @Module: Modules类里面的方法专门提供依赖，所以我们定义一个类，用@Module注解，这样Dagger在构造类的实例的时候，就知道从哪里去找到需要的 依赖。modules的
一个重要特征是它们设计为分区并组合在一起（比如说，在我们的app中可以有多个组成在一起的modules）。
- @Provides: 在modules中，我们定义的方法是用这个注解，以此来告诉Dagger我们想要构造对象并提供这些依赖。
- @Component: Components从根本上来说就是一个注入器，也可以说是@Inject和@Module的桥梁，它的主要作用就是连接这两个部分。 Components可以提供所有定义了的
类型的实例，比如：我们必须用@Component注解一个接口然后列出所有的　　 @Modules组成该组件，如 果缺失了任何一块都会在编译的时候报错。所有的组件都可以通过它的modules知道依赖的范围。
- @Scope: Scopes可是非常的有用，Dagger2可以通过自定义注解限定注解作用域。后面会演示一个例子，这是一个非常强大的特点，因为就如前面说的一样，没必要让每个对象都去了解如何管理他们的实例。
