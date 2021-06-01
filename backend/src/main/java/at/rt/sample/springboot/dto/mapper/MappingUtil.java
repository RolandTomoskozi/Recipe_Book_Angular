package at.rt.sample.springboot.dto.mapper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MappingUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static ApplicationContext applicationContext() {
        return applicationContext;
    }

    protected MappingUtil() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MappingUtil.applicationContext = applicationContext;
    }
}
