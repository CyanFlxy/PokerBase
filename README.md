# PokerBase
扑克牌基础资源库

# 接入说明

这不是一个独立的工程，而是一个单独的(Android Studio)module。

接入方法如下：

1. 将工程代码复制到你的工程目录下（或者可以使用子模块的形式远程接入）

2. 在工程根目录中的settings.gradle文件中添加下面这一行代码

```
include ':PokerBase'
```

3. 在要接入PokerBase的工程的build.gradle文件中添加以下代码，并执行sync。
```
dependencies {
    implementation project(path: ':PokerBase')
}
```