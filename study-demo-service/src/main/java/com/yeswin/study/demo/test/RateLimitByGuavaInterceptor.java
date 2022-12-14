package com.yeswin.study.demo.test;


import com.google.common.util.concurrent.RateLimiter;
import com.yeswin.common.core.response.YeswinCode;
import com.yeswin.common.core.response.YeswinException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 把这个拦截器添加到 web 拦截器，制定需要的路径，对应的路径就能拦截。
 * 但是注意，当前实现是单个 rateLimit，配置拦截符合的接口路径一起共享这个值
 * 如果希望不同接口使用不同值，请创建不同的拦截器并配置好路径
 */
public class RateLimitByGuavaInterceptor implements HandlerInterceptor {

    /**
     * 3k 个令牌桶每秒
      */
    private RateLimiter rateLimiter = RateLimiter.create(3000);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (rateLimiter.tryAcquire()) {
            return true;
        }
        throw new YeswinException(YeswinCode.DEFAULT_RATE_LIMIT, "活动火爆，请稍后再试");
    }
}
