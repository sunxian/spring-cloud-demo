package com.woxian.springcloud.config;

import jdk.nashorn.internal.objects.Global;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Component
@Slf4j
public class MyLogGateWayFilter implements   GlobalFilter,Ordered{

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("进入全局过滤器");
        String name=exchange.getRequest().getQueryParams().getFirst("name");
        if(name==null){
            log.info("用户名为null,非法用户");
            //exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            //return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
