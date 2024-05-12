package com.apex.clinique.configurations;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class aop {

    @After("execution(* com.apex.clinique.service.*.add*(..))")
    public void logAvantMethode(JoinPoint joinPoint) {
        System.out.println("** apres l'exécution de la méthode : " + joinPoint.getSignature().getName());
    }
/*
    @Before("execution(* *(..))")
    public void logApresMethode(JoinPoint joinPoint) {
        System.out.println("** avant l'exécution de la méthode : " + joinPoint.getSignature().getName());
    }*/
}

