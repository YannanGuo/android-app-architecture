#MVP框架基本原理

![](https://github.com/guoxiaoxing/android-mvp-architecture-pratice/blob/master/image/mvp_structure.png)

Presenter 是Model和View的中间衔接层，一个标准的Presenter中应该至少包含一个Model和一个View。
在MVP模式中，View是不允许与Model交互的，View只是负责展示数据，是彻底的哑View。当View需要更新数据时，
需要通过Presenter来操作Model，Model获取到数据后再通过Presenter来更新View。
Presenter不直接操作数据（更新数据状态），需要调用Model操作数据（更新数据状态）

#一 View层

显示层，主要负责：

1. 提供UI交互
2. 在presenter的控制下修改UI。
3. 将业务事件交由presenter处理。
注意：View层不存储数据，不与Model层交互。

#二 Presenter层

逻辑处理层，主要负责：

1. 对UI的各种业务事件进行相应处理。也许是与Model层交互，也许自己进行一些计算，也许控制后台Task，Servic
2. 对各种订阅事件进行响应，修改UI。
3. 临时存储页面相关数据。

注意：Presenter内不出现View引用。

#三 Model层

数据层，主要负责：

1. 从网络，数据库，文件，传感器，第三方等数据源读写数据。
2. 对外部的数据类型进行解析转换为APP内部数据交由上层处理。
3. 对数据的临时存储,管理，协调上层数据请求。
注意：Model层不同于Java的Bean类，它包含类业务逻辑和数据的处理，它会把数据处理程POJO对象送往Presenter层。

