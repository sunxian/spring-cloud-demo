package cloudalibaba.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class IDGeneratorSnowflake {
    private  long workerId=0;
    private  long datacenterId=0;
    private Snowflake snowflake= IdUtil.createSnowflake(workerId,datacenterId);
//  @PostConstruct
//    public  void  init() {
//        try {
//            log.info("host {}",NetUtil.getLocalhostStr());
//            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
//            log.info("当前的workerId:{}", workerId);
//        } catch (Exception e) {
//             e.printStackTrace();
//             log.warn("当前机器的workerId获取失败");
//        }finally {
//
//        }


   // }


    public  synchronized long snowflaked(){
        return snowflake.nextId();
    }

//    public  synchronized long snowflaked(long workerId,long datacenterId) {
//        snowflake = IdUtil.createSnowflake(workerId, datacenterId);
//        return snowflake.nextId();}


}
