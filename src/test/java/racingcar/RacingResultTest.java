package racingcar;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingWinners;
import racingcar.vo.CarName;

public class RacingResultTest {


    List<CarName> carNames;

    @BeforeEach
    void carNamesInit() {
        List<String> carNameStrings = Arrays.asList("1", "2", "3");

        carNames = carNameStrings.stream()
                                               .map(CarName::new)
                                               .toList();
    }



    @DisplayName("가장 많은 전진횟수를 가지는 자동차가 우승자로 출력되는지 테스트")
    @Test
    void RacingWinnersCheckTest() {

        List<Car> cars = carNames.stream()
                                 .map(Car::new)
                                 .toList();
        cars.get(0).moveForward();
        RacingCars racingCars = new RacingCars(cars);
        RacingWinners winners = racingCars.calculateRacingWinners();
        Assertions.assertThat(winners.showNamesSplitByComma()).isEqualTo("1");

    }


    @DisplayName("우승자가 여러명일 경우 여러 명이 콤마로 나누어져 출력되는지 테스트")
    @Test
    void PluralRacingWinnersTest() {

        List<Car> cars = carNames.stream()
                                 .map(Car::new)
                                 .toList();
        cars.get(0).moveForward();
        cars.get(1).moveForward();

        RacingCars racingCars = new RacingCars(cars);
        RacingWinners winners = racingCars.calculateRacingWinners();

        Assertions.assertThat(winners.showNamesSplitByComma()).isEqualTo("1, 2");

    }




}
