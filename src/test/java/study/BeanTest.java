package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import racingcar.config.AppConfig;

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

}
