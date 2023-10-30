package racingcar.domain;

import org.junit.jupiter.api.Test;

public class RaceTest {

    @Test
    void 주어진_횟수동안_자동차는_전진하거나_멈춘다() {
        Car car = new Car("테스트");
        Race race = new Race(5, new Car[]{car});

        race.startRace();

        assertThat(car.getPosition()).isBetween(0,5);
    }

}
