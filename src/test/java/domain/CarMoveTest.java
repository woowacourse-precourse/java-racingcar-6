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
    void moveCar(Car car) {
        //when
        car.move();
        CarLocation carLocation = car.getCarLocation();

        Assertions.assertThat(carLocation.getValue()).isEqualTo(1);
    }

    public static Stream<Arguments> provideCarAndGoNumber() {
        return Stream.of(
                createTestCase("name1"),
                createTestCase("name2"),
                createTestCase("name3"),
                createTestCase("name4"),
                createTestCase("name5"));

    }


    private static Arguments createTestCase(String carName) {
        return Arguments.of(
                CarFactory.createCar(carName, 0,new OneStepMoveStrategy()));
    }
}
