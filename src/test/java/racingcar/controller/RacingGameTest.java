package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingGameTest {
    @Test
    @DisplayName("participants 필드가 제대로 구성되는지")
    public void setParticipants() {
        RacingGame testGame = new RacingGame();
        String[] names = {"poky", "minsu", "pobi"};

        assertThat(testGame.setParticipants(names).stream().map(Car::getName))
                .contains("poky", "minsu", "pobi");
    }

    @Test
    @DisplayName("최종 우승자를 확인할 수 있는지")
    public void getWinner() {
        RacingGame testGame = new RacingGame();

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("poky", 5));
        cars.add(new Car("pobi", 3));
        cars.add(new Car("jun", 5));

        assertThat(testGame.getWinner(cars))
                .containsOnly("poky", "jun");
    }
}
