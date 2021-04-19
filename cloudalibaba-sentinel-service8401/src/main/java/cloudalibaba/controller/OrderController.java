package cloudalibaba.controller;

import cloudalibaba.service.OrderService;
import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.woxian.springcloud.entities.CommonResult;
import com.woxian.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @GetMapping("/testA")
    public String getEcho() {
        String s = "testA******** ";
        return s;
    }

    @GetMapping("/testB")
    public String getEcho1() {
        String s = "testB******** ";
        IdUtil.createSnowflake(0, 1);
        return s;
    }

    @Resource
    private OrderService orderService;

    @GetMapping("/getid")
    public long getId() throws InterruptedException {

        return orderService.getId() ;
    }

    @GetMapping("/getinfo")
    @SentinelResource(value = "getinfo")
    public String getInfo() {

        return "ok" ;
    }


    @GetMapping("/byresource")
    @SentinelResource(value = "hello",blockHandlerClass =CustomerBlockHandler.class,blockHandler = "handExcep2")
    public CommonResult rateLimit() {

        return new CommonResult<>(200,"按资源名限流",new Payment(2L,"helloworld"));


    }

    public CommonResult handleException(BlockException e){
        return new CommonResult<>(444,e.getClass().getCanonicalName()+" not available",null);
    }

}
