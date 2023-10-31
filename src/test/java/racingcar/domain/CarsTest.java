package racingcar.domain;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
        List<Car> carList = Arrays.asList(mock(Car.class), // Mock Car 객체 생성
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
}