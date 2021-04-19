package cloudalibaba.service;

import cloudalibaba.util.IDGeneratorSnowflake;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class OrderService {
    //雪花算法生成全局唯一id
    @Resource
    private IDGeneratorSnowflake idGeneratorSnowflake;

    public  long getId() throws InterruptedException {
        log.info("************************start**");
        ExecutorService executorService=Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
           // TimeUnit.SECONDS.sleep(1);
           executorService.submit(()->{
              System.out.println(idGeneratorSnowflake.snowflaked());});
        }

        executorService.shutdown();
        return 0;
    }
}
