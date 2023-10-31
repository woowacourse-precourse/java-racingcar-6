package domain;

import dto.WinnerDto;
import factory.CarFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CarRaceResultEvaluatorTest {

    @ParameterizedTest
    @DisplayName("우승자 판별기 검증")
    @MethodSource("provideCars")
    void testGetWinners(Cars cars, WinnerDto expectedWinner) {
        //given
        CarRaceResultEvaluator evaluator = new CarRaceResultEvaluator();
        //when
        WinnerDto result = evaluator.getWinners(cars);
        //then
        Assertions.assertThat(result).isEqualTo(expectedWinner);
    }

    private static Stream<Arguments> provideCars() {
        return Stream.of(
                Arguments.of(
                        createCars(1, 3),
                        new WinnerDto(List.of("car2"))
                ),
                Arguments.of(
                        createCars(2, 2),
                        new WinnerDto(List.of("car1", "car2"))
                )
        );
    }

    private static Cars createCars(int firstCarLocation, int secondCarLocation) {
        return new Cars(Arrays.asList(
                createCar("car1", firstCarLocation),
                createCar("car2", secondCarLocation)));
    }

    private static Car createCar(String carName, int carLocation) {
        return CarFactory.createCar(carName, carLocation,new OneStepMoveStrategy());
    }
}
