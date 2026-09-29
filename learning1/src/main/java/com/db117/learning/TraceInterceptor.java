package com.db117.learning;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

/** 在 CDI 调用前后记录耗时，演示 AroundInvoke 拦截。 */
@Trace
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class TraceInterceptor {

    @AroundInvoke
    Object trace(InvocationContext context) throws Exception {
        long started = System.nanoTime();
        try {
            return context.proceed();
        } finally {
            System.out.println(context.getMethod().getName() + " took "
                    + (System.nanoTime() - started) + " ns");
        }
    }
}
