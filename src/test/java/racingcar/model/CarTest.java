package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.request.CarName;

class CarTest {

    private static final String testName = "test";
    private static final CarName testCarName = new CarName(testName);

    @Test
    @DisplayName("CarName과 NumberGenerator로 Car 클래스를 생성한다.")
    void createCar() {
        // Given
        NumberGenerator numberGenerator = mock(NumberGenerator.class);

        // When
        Car car = new Car(testCarName, numberGenerator);

        // Then
        assertEquals(testName, car.getName());
        assertEquals(0, car.getMoveCount());
    }

    @Test
    @DisplayName("numberGenerator의 숫자가 4 이상일 때 Car는 이동한다.")
    void ifGeneratedNumberIs4OrAboveCarMove() {
        // Given
        NumberGenerator mockNumberGenerator = mock(NumberGenerator.class);
        Car car = new Car(testCarName, mockNumberGenerator);

        // When
        when(mockNumberGenerator.generateInRange(anyInt(), anyInt())).thenReturn(4);
        car.tryMove();

        // Then
        assertEquals(1, car.getMoveCount());

        // When
        when(mockNumberGenerator.generateInRange(anyInt(), anyInt())).thenReturn(5);
        car.tryMove();

        // Then
        assertEquals(2, car.getMoveCount());
    }

    @Test
    @DisplayName("numberGenerator의 숫자가 4 미만일 때 Car는 이동하지 않는다.")
    void ifGeneratedNumberIsLessThan4CarNotMove() {
        // Given
        NumberGenerator mockNumberGenerator = mock(NumberGenerator.class);
        Car car = new Car(testCarName, mockNumberGenerator);

        // When
        when(mockNumberGenerator.generateInRange(anyInt(), anyInt())).thenReturn(3);
        car.tryMove();

        // Then
        assertEquals(0, car.getMoveCount());

        // When
        when(mockNumberGenerator.generateInRange(anyInt(), anyInt())).thenReturn(2);
        car.tryMove();

        // Then
        assertEquals(0, car.getMoveCount());
    }
}
