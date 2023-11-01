package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    void getName() {
        RacingCar racingCar = new RacingCar("Cha");

        String name = racingCar.getName();

        assertThat(name).isEqualTo("Cha");
    }

    @Test
    void getMoveCount() {
        RacingCar racingCar = new RacingCar("Cha");

        Integer moveCount = racingCar.getMoveCount();

        assertThat(moveCount).isEqualTo(0);
    }

}