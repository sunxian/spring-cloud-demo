package cloudalibaba.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.woxian.springcloud.entities.CommonResult;

public class CustomerBlockHandler {

    public static CommonResult handExcep1(BlockException e){
        return new CommonResult(444,"sorry server is busy",null);

    }
    public static CommonResult handExcep2(BlockException e){
        return new CommonResult(444,"sorry server is busy,plz wait",null);

    }
}
