# FragmentDemo

Fragment之间不能直接传递数据


fragment之间的通信
方式|优点|缺点
--|--|--
handler| | 耦合度高
           无法获取Activity的返回结果
           内存泄漏

fragment

handler
缺点



static 静态变量占用内存

广播

性能差
通信体系，一个发生，多个结束
传播数据有限
代码冗余

EventBus
方便、便捷、简单

反射，性能打折，效率低
代码维护困难
数据无法返回，单项传送

接口
简单，效率高，方便，解耦合

代码冗余，每个需要通信的Fragment都必须定义自己独一无二的接口