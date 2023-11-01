package service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import util.BeanFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.IntStream;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CarMoveServiceTest {

    private CarMoveService carMoveService;
    private Method createRandom;

    @BeforeAll
    public void init() throws NoSuchMethodException {
        this.carMoveService = BeanFactory.getInstanceCarMoveService();
        createRandom = carMoveService.getClass().getDeclaredMethod("createRandom");
        createRandom.setAccessible(true);
    }

    @Test
    public void 생성한_숫자는_1부터_9_사이다(){

        IntStream.range(0,100).forEach(i -> {
            try {
                int randomNum = (int) createRandom.invoke(carMoveService);
                assertTrue(randomNum>=0&&randomNum<=9);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    public void _4_이상의_수는_전진한다() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //TODO move method를 테스트해야 하는데 private이라 방법을 모르겠다...
    }

}