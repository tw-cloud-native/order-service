package com.dmall.orderservice.adapter.product;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.stereotype.Service;

@Service
public class ProductImageGetterCommand extends HystrixCommand<String> {
    private static final String COMMAND_GROUP = "default";

    public ProductImageGetterCommand() {
        super(HystrixCommandGroupKey.Factory.asKey(COMMAND_GROUP));
    }

    @Override
    protected String run() throws Exception {
        throw new RuntimeException("I will always fail");
    }

    @Override
    protected String getFallback() {
        return "Powered by fallback too";
    }
}
