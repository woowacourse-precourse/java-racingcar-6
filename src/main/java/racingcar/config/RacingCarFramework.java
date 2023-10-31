package racingcar.config;

import java.lang.reflect.Method;
import java.util.Arrays;

public final class RacingCarFramework {
    private static final RacingCarFramework instance = new RacingCarFramework(new RacingCarConfiguration());
    private final RacingCarConfiguration configuration;

    private RacingCarFramework(RacingCarConfiguration configuration) {
        this.configuration = configuration;
    }

    public static RacingCarFramework getInstance() {
        return instance;
    }

    public <T> T getBean(Class<T> clazz) {
        Method beanCreateMethod = findBeanCreateMethod(clazz);
        return createBean(beanCreateMethod);
    }

    private Method findBeanCreateMethod(Class<?> clazz) {
        return Arrays.stream(RacingCarConfiguration.class.getDeclaredMethods())
                .filter(method -> method.getReturnType().equals(clazz))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 클래스의 빈이 없습니다."));
    }

    private <T> T createBean(Method beanCreateMethod) {
        boolean accessible = beanCreateMethod.canAccess(configuration);

        try {
            beanCreateMethod.setAccessible(true);
            return (T) beanCreateMethod.invoke(configuration);
        } catch (Exception e) {
            throw new IllegalArgumentException("해당하는 클래스의 빈을 생성할 수 없습니다.");
        } finally {
            beanCreateMethod.setAccessible(accessible);
        }
    }
}
