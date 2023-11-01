package racingcar.domain;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import racingcar.exception.CarListEmptyException;
import racingcar.service.RandomNumberGenerator;
import racingcar.service.BasicMovementRule;

public class CarsTest {

    @Mock
    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("자동차의 개수만큼 RandomNumber가 생성된다")
    @Test
    void generateRandomNumberByCarsNumber() {
        List<Car> carList = Arrays.asList(mock(Car.class),
                mock(Car.class),
                mock(Car.class));
        Cars cars = new Cars(carList);
        BasicMovementRule basicMovementRule = new BasicMovementRule();
        cars.moveAll(basicMovementRule, randomNumberGenerator);

        when(randomNumberGenerator.generateRandomNumber()).thenReturn(5);

        for (Car car : carList) {
            verify(car, times(1)).move(eq(basicMovementRule), anyInt());
        }
    }

    @DisplayName("차의 위치가 제일 높은 것을 반환한다. 차량 리스트가 없을 경우 예외를 발생시킨다")
    @Test
    void findMaxCarPosition() {
        Car expect = new Car("pboi");
        List<Car> carList = Arrays.asList(expect,
                new Car("jun"),
                new Car("seok"));

        List<Car> emptyList = new ArrayList<>();

        Cars emptyCars = new Cars(emptyList);
        BasicMovementRule basicMovementRule = new BasicMovementRule();

        carList.get(0).move(basicMovementRule, 6);
        carList.get(0).move(basicMovementRule, 6);
        carList.get(0).move(basicMovementRule, 6);

        Cars cars = new Cars(carList);

        Car actual = cars.findMaxCarPosition();

        Assertions.assertAll(
                () -> Assertions.assertEquals(expect, actual),
                () -> Assertions.assertThrows(CarListEmptyException.class,
                        emptyCars::findMaxCarPosition)
        );
    }
}