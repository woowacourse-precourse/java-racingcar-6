package service;

import domain.Car;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import util.BeanFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
                assertTrue(randomNum>=1&&randomNum<=9);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    public void _4_이상의_수는_전진한다() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Car car = new Car("test");

        CarMoveService carMoveService = new CarMoveService();
        CarMoveService mockCarMoveService = mock(CarMoveService.class);
        when(createRandom.invoke(mockCarMoveService)).thenReturn(5); // mock 객체는 4이상의 수를 반환한다

        Method move = CarMoveService.class.getDeclaredMethod("move",Car.class);
        move.setAccessible(true);
        move.invoke(mockCarMoveService,car);

        assertEquals(1, car.getMoveCount());
    }

}