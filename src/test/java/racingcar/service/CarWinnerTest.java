package racingcar.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarWinnerTest {

    @Test
    @DisplayName("우승자가 한명일 때 올바르게 출력되는지 테스트")
    public void individualWinner() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", "-----"),
                new Car("woni", "---"),
                new Car("jun", "--")
        );

        CarResult result = new CarResult(cars);
        CarWinner carWinner = new CarWinner(result);
        String winner = carWinner.printWinner();
        assertThat("pobi").isEqualTo(winner);
    }

    @Test
    @DisplayName("우승자가 한명 이상일 때 올바르게 출력되는지 테스트")
    public void multipleWinner() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", "-----"),
                new Car("woni", "-----"),
                new Car("jun", "--")
        );
        CarResult result = new CarResult(cars);
        CarWinner carWinner = new CarWinner(result);
        String winner = carWinner.printWinner();
        assertThat(winner).contains(",");

        String[] winners = winner.split(",");
        assertThat(winners.length).isEqualTo(2);
    }
}