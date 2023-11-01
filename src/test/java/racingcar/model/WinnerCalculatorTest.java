package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerCalculatorTest {
    private WinnerCalculator winnerCalculator = new WinnerCalculator();

    @DisplayName("한 자동차만 전진했을 때 최종 우승자 출력")
    @Test
    void printOneMoveCase() {
        Car car1 = new Car("tomas");
        Car car2 = new Car("emily");
        car1.move();
        List<Car> cars = List.of(car1, car2);
        String winners = winnerCalculator.getWinners(cars);
        assertThat(winners).isEqualTo("최종 우승자 : tomas");
    }

    @DisplayName("두 자동차 모두 전진했을 때 최종 우승자 출력")
    @Test
    void printTwoMoveCase() {
        Car car1 = new Car("tomas");
        Car car2 = new Car("emily");
        car1.move();
        car2.move();
        List<Car> cars = List.of(car1, car2);
        String winners = winnerCalculator.getWinners(cars);
        assertThat(winners).isEqualTo("최종 우승자 : tomas, emily");
    }

    @DisplayName("두 자동차 모두 전진하지 못 했을 때 최종 우승자 출력")
    @Test
    void printNothingMoveCase() {
        Car car1 = new Car("tomas");
        Car car2 = new Car("emily");
        List<Car> cars = List.of(car1, car2);
        String winners = winnerCalculator.getWinners(cars);
        assertThat(winners).isEqualTo("최종 우승자 : tomas, emily");
    }
}
