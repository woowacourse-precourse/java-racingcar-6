package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import racingcar.config.AppConfig;
import racingcar.config.AutoAppConfig;

class BeanTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("AppConfig의 모든 빈 출력")
    void checkBeansInAppConfig() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    @DisplayName("Appconfig의 빈들 메타데이터 출력")
    void checkBeansMetaDataInAppConfig() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String name : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(name);
            System.out.println(beanDefinition);
        }
    }

    @Test
    @DisplayName("스프링 컨테이너에서 빈이 어떤 형식으로 저장되는지 출력")
    void checkBeanDeep() {
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = " + bean.getClass());
    }

    @Test
    @DisplayName("AutoAppConfig의 모든 빈 출력")
    void checkBeansInAutoAppConfig() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
            AutoAppConfig.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

}
