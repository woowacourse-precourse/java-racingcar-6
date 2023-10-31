package racingcar;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.name.CarName;
import racingcar.randomvalue.RandomValueGenerator;

class CarMovementDeciderTest {

    private RandomValueGenerator mockRandomValueGenerator;
    private CarMovementDecider carMovementDecider;

    @BeforeEach
    public void setUp() {
        mockRandomValueGenerator = mock(RandomValueGenerator.class);
        carMovementDecider = new CarMovementDecider(mockRandomValueGenerator);
    }

    @Test
    public void moveFoward() {
        // Given
        given(mockRandomValueGenerator.generate()).willReturn(4);

        Car car = new Car(new CarName("car"));
        List<Car> carList = List.of(car);

        // When
        carMovementDecider.move(carList);

        // Then
        Assertions.assertThat(car.getDistanceDriven()).isEqualTo(1);
    }

    @Test
    public void notMove() {
        // Given
        given(mockRandomValueGenerator.generate()).willReturn(3);

        Car car = new Car(new CarName("car"));
        List<Car> carList = List.of(car);

        // When
        carMovementDecider.move(carList);

        // Then
        Assertions.assertThat(car.getDistanceDriven()).isEqualTo(0);
    }
}
