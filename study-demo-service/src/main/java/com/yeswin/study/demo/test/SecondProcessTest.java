package com.yeswin.study.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SecondProcessTest implements BeanPostProcessor, InitializingBean, BeanNameAware, BeanFactoryAware {


    private int beforeCount;
    private int afterPropertiesSetCount;
    private int beanFactoryCount;
    private int beanNameCount;

    @Autowired
    private FirstProcessTest firstProcessTest;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("SecondProcessTest postProcessBeforeInitialization, ，当前 bean {}, 已执行 {}", bean, ++beforeCount);
        if (beanName.contains("SecondProcessTest")) {
            log.info("自己没有了吧，测试一下");
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//       log.info("SecondProcessTest {}", ++afterPropertiesSetCount);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("SecondProcessTest postProcessAfterInitialization");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("beanFactoryCount {}, {}", beanFactory, ++beanFactoryCount);
    }

    @Override
    public void setBeanName(String name) {
        log.info("setBeanName {}, {}", name, ++beanNameCount);
    }

//    @Override
//    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
//    }
//
//    @Override
//    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
//    }
//
//    @Override
//    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
//        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
//    }
}
