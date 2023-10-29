package domain;

import factory.CarFactory;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarMoveTest {

    @ParameterizedTest
    @DisplayName("자동차 전진 검증 테스트")
    @MethodSource("provideCarAndGoNumber")
    void moveCar(Car car, int randomNumber) {
        //when
        car.move(randomNumber);
        CarLocation carLocation = car.getCarLocation();

        Assertions.assertThat(carLocation.getCarLocation()).isEqualTo(1);
    }

    public static Stream<Arguments> provideCarAndGoNumber() {
        return Stream.of(
                createTestCase("name1", 5),
                createTestCase("name2", 6),
                createTestCase("name3", 7),
                createTestCase("name4", 8),
                createTestCase("name5", 9));


    }

    @ParameterizedTest
    @DisplayName("자동차 정지 검증 테스트")
    @MethodSource("provideCarAndStopNumber")
    void stopCar(Car car, int randomNumber) {
        //when
        car.move(randomNumber);
        CarLocation carLocation = car.getCarLocation();

        Assertions.assertThat(carLocation.getCarLocation()).isEqualTo(0);
    }

    public static Stream<Arguments> provideCarAndStopNumber() {
        return Stream.of(
                createTestCase("name1", 1),
                createTestCase("name2", 2),
                createTestCase("name3", 3));


    }


    private static Arguments createTestCase(String carName, int randomNumber) {
        return Arguments.of(
                CarFactory.createCar(
                        carName,
                        0,
                        new RandomForwardStrategy()), randomNumber);
    }
}
