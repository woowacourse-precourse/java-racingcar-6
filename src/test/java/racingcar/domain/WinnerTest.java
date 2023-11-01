package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinnerTest {

    @Test
    @DisplayName("전진 횟수가 가장큰 자동차가 우승자가 된다.")
    void getWinner() {
        // given
        Car loseCar = new Car("test1", 0);
        Car winCar = new Car("test2", 1);
        List<Car> cars = List.of(loseCar, winCar);

        Winner winner = new Winner(cars);

        // when
        List<Car> actual = winner.getWinners();

        // then
        List<Car> expected = List.of(winCar);
        Assertions.assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("전진 횟수가 가장 큰 자동차가 여러 대일 경우 우승자는 여러 명이 된다.")
    void getWinners() {
        // given
        Car winCar1 = new Car("test1", 1);
        Car winCar2 = new Car("test2", 1);
        List<Car> cars = List.of(winCar1, winCar2);

        Winner winner = new Winner(cars);

        // when
        List<Car> actual = winner.getWinners();

        // then
        List<Car> expected = List.of(winCar1, winCar2);
        Assertions.assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }
}