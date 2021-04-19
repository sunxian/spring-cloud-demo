# spring cloud alibaba

![image-20210409120405462](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210409120405462.png)

![image-20210409120537980](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210409120537980.png)

**Nacos支持AP和CP的切换**

Nacos干翻eureka +config +bus

namespace group DataID

生产环境Nacos集群配置和持久化配置

windows da单机版运行 startup.cmd -m standalone  端口号默认8848



**sentinel**

![image-20210412204345168](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210412204345168.png)

限流

![image-20210411112639463](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210411112639463.png)

Sentinel断路器没有半开状态

端口号默认8080

流控 降级 热点key限流  系统规则

按url限流和按资源名称限流

结合Nacos 将sentinel的限流配置持久化

![image-20210412202445086](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210412202445086.png)

![image-20210411122955896](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210411122955896.png)

hutu工具包实现

UidFenerator  美团点评Leaf



**Seata**

![image-20210413103033174](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210413103033174.png)

![image-20210413102953419](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210413102953419.png)

- 一阶段：业务数据和回滚日志记录在同一个本地事务中提交，释放本地锁和连接资源。
- 二阶段：
  - 提交异步化，非常快速地完成。
  - 回滚通过一阶段的回滚日志进行反向补偿。

![image-20210413160616044](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210413160616044.png)

![image-20210413161142267](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210413161142267.png)

http://seata.io/zh-cn/docs/overview/what-is-seata.html

阿里云GTS 付费应用 大厂使用