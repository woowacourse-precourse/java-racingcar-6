package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class RaceTest {

    @Test
    void 경주에_참가하는_자동차_반환() {
        Race race = new Race("pobi", "woni", "jun");
        List<Car> cars = race.getCars();
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
    }

    @Test
    void 경주_시작() {
        Race race = new Race("pobi", "woni", "jun");
        race.start();
    }

    @Test
    void 최종_우승자_확인() {
        Race race = new Race("pobi", "woni", "jun");
        race.start();

        List<Car> winners = race.getWinners();
        assertThat(winners).isNotEmpty();
    }
}