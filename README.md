# Michel
Michel Java Server Software for Minecraft: Bedrock Edition.

一个轻量级的服务端框架,基于nukkit而开发，目前正在开发过程..

第一步实现框架

目前Michel第一步就是把raknet,log,plugin搞定
log和plugin都会有所创新
在此之前是把开发环境搭建起来，实现模块化编程和模块联合编译
raknet,plugin,log用java写就行
具体的话就是log和plugin的创新

1.raknet提升效率为主
2. log的异常输出优化，提供专门优化的异常信息输出，并且log信息体现输出所在类名和代码行数(这些事参考目前很多大数据框架的log输出)，log全部提现插件名称
3. plugin在保留原来传统plugin.yml结构同时，添加简易插件加载系统(我之前pr的那个)

另外添加几个待议的

1. 完全使用注解系统
2. 插件镜像系统-可以实现插件的下载，并且插件镜像可以自己搭建
3. 数据库支持库-简化数据库开发
4. 经济，生物ai的内嵌
5. 工具类的添加
6. 添加我自己写的配置文件解析器(oaml解析器)
