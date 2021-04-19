# sping cloud

![image-20210319194847426](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210319194847426.png)

![image-20210319200609488](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210319200609488.png)

分布式微服务架构的一揽子解决方案

![image-20210319204937441](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210319204937441.png)

![image-20210327214739380](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210327214739380.png)

![image-20210327214921156](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210327214921156.png)

集群 互相注册 相互守望

hosts C:\Windows\System32\notepad.exe

Eureka 属于CAP里面的AP 自我保护机制

Zookeeper 属于CP

![image-20210328123830595](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210328123830595.png)

## Ribbon

LB 负载均衡 +RestTemplate调用

Ribbon是netflix实现的客户端负载均衡工具 目前在维护状态 但是生产仍被大规模使用 替代者 spring cloud loadbalancer

![image-20210404172435931](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210404172435931.png)

![image-20210330182659910](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210330182659910.png)

![image-20210404173237731](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210404173237731.png)

![image-20210330183111488](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210330183111488.png)

![image-20210330183227196](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210330183227196.png)

zookeeper集群和consul集群的安装

openFeign 代替ribbon+restTemplate实现服务调用 oprnFeign默认支持ribbon

openFeign超时控制 默认为1s

openFeign日志增强

**Hystrix**断路器  停更进维 替代方案阿里巴巴 sentinel

Hystrix是一个处理分布式系统的延迟和容错的开源库

在分布式系统里，许多依赖不可避免的会调用失败，超时、异常等 Hystrix能够保证在一个依赖初吻的情况想，

不会导致整体服务失败，避免级联故障，以提高分布式系统的弹性

断路器 类似家里的熔断保险丝

Fallback    服务降级    服务器忙，不让客户端等待并立刻返回一个友好提示 程序运行异常 超时 服务熔断触发 线程池/信号量打满

 服务熔断 break   达到最大访问后，直接拒绝访问，然后调用服务降级方法

服务限流 flowlimit   秒杀高并发操作，严禁一蜂窝过来拥挤，大家排队，一秒钟N个，有序进行



@HystrixCommand内属性的修改建议重启微服务

请求次数计算

 

![image-20210407104557061](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210407104557061.png)

tomcat线程池

![image-20210407112108592](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210407112108592.png)

![image-20210407115431485](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210407115431485.png)

![image-20210407115445388](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210407115445388.png)

![image-20210407115837856](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210407115837856.png)

架构思想

Spring cloud gateway 非阻塞异步模型

Spring Cloud Gateway features:

- Built on Spring Framework 5, Project Reactor and Spring Boot 2.0
- Able to match routes on any request attribute.
- Predicates and filters are specific to routes.
- Circuit Breaker integration.
- Spring Cloud DiscoveryClient integration
- Easy to write Predicates and Filters
- Request Rate Limiting
- Path Rewriting

![image-20210407120625195](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210407120625195.png)

![image-20210407121121184](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210407121121184.png)

三大核心概念 Route Predicate 匹配规则（请求头 请求时间 cookie host） Filter过滤 请求前后的精细控制

![image-20210407121833420](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210407121833420.png)

![image-20210407121916004](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210407121916004.png)

Spring cloud config ![image-20210407140505368](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210407140505368.png)

![image-20210407142613209](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210407142613209.png)



![image-20210407144525901](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210407144525901.png)

手动刷新配置  curl -X POST "http://localhost:3355/actuator/refresh"

![image-20210408115354600](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210408115354600.png)

Spring Cloud Bus

 **消息总线** 与config搭配使用 **实现配置的动态刷新** Bus支持两种消息代理 RabbitMQ和Kafka

![image-20210407145303113](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210407145303113.png)

![image-20210407155951219](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210407155951219.png)

![image-20210408133843498](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210408133843498.png)

![image-20210408134150832](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210408134150832.png)

curl -X POST "http://localhost:3344/actuator/bus-refresh"

curl -X POST "http://localhost:3344/actuator/bus-refresh/config-client:3366" 也可以手动刷新客户端，让客户端拉取 curl -X POST "http://localhost:3355/actuator/refresh"

![image-20210408144002247](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210408144002247.png)

![image-20210408144807768](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210408144807768.png)

Spring Cloud Stream

![image-20210408150153027](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210408150153027.png)

![image-20210408151910381](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210408151910381.png)

![image-20210408152224410](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210408152224410.png)

spring cloud stream消费组的概念