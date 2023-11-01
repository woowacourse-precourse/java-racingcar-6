package racingcar.domain.raingcar;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RacingCarsTest {

    @DisplayName("중복된 이름의 자동차가 있을 경우 IllegalArgumentException 발생")
    @Test
    void racingCarDuplicateTest() {

        // Arrange
        List<RacingCar> carList = List.of(
                new RacingCar("pobi"),
                new RacingCar("pobi"),
                new RacingCar("woni")
        );

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new RacingCars(carList);
        });
    }

    @ParameterizedTest
    @MethodSource("getValues")
    @DisplayName("자동차 이름 입력 시, RacingCars 객체 생성 테스트")
    void fromNames(String[] inputs) {

        // Act
        RacingCars cars = RacingCars.fromNames(inputs);

        // Assert
        Assertions.assertEquals(inputs.length, cars.getSize());
    }

    @DisplayName("레이싱 카 후보 중 가장 많이 전진한 자동차의 위치 반환 테스트")
    @Test
    void getMaxPosition() {
        // Arrange
        List<RacingCar> carList = List.of(
                new RacingCar("pobi", 2),
                new RacingCar("woni", 7),
                new RacingCar("jun", 9)
        );

        // Act
        RacingCars cars = new RacingCars(carList);

        // Assert
        Assertions.assertEquals(9, cars.getMaxPosition());
    }

    private static Stream<Arguments> getValues() {
        return Stream.of(
                Arguments.of(
                        (Object) new String[]{"pobi", "woni", "jun"}
                ),
                Arguments.of(
                        (Object) new String[]{"pobi"}
                )
        );
    }
}