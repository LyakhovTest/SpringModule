package aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* findUserById(long))")
    public void beforeGetUser(){
        System.out.println("beforeGetUser: попытка получить Пользователя");
    }
}
