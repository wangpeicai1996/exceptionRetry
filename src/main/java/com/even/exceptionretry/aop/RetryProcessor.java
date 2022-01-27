package com.even.exceptionretry.aop;

import com.even.exceptionretry.annotation.Retry;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.lang.reflect.Method;

@Aspect
@Component
@Order(1)
public class RetryProcessor {

    @Pointcut("@annotation(com.even.exceptionretry.annotation.Retry)")
    public void cutMethod() {

    }


    @Around("cutMethod() && @annotation(com.even.exceptionretry.annotation.Retry)")
    @Transactional(rollbackOn = Exception.class)
    public Object tryAgain(ProceedingJoinPoint joinPoint) throws Throwable {
        int count = 0;
        OptimisticLockingFailureException lockFailureException = null;
        Retry retry = (Retry) getMethodAnnotation(joinPoint);
        //循环执行方法，正常return的话就执行一次，如果抛异常，就会循环执行方法，直到到达次数，或者中间某一次成功
        do {
            count++;
            try {
                System.out.println("执行方法" + count + "次");
                return joinPoint.proceed();
            } catch (ObjectOptimisticLockingFailureException e) {
                System.out.println("乐观锁重试" + count + "次失败");
                e.printStackTrace();
                lockFailureException = e;
            }
        } while (count < retry.value());
        throw lockFailureException;
    }


    /**
     * 获取注解信息
     *
     * @param joinPoint
     * @return
     * @throws NoSuchMethodException
     */
    public Object getMethodAnnotation(ProceedingJoinPoint joinPoint) throws NoSuchMethodException {
        String methodName = joinPoint.getSignature().getName();
        Class<?> clazz = joinPoint.getTarget().getClass();
        // 拿到方法对应的参数类型
        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
        // 根据类、方法、参数类型（重载）获取到方法的具体信息
        Method objMethod = clazz.getMethod(methodName, parameterTypes);
        // 拿到方法定义的注解信息
        Retry annotation = objMethod.getDeclaredAnnotation(Retry.class);
        return annotation;
    }


}
