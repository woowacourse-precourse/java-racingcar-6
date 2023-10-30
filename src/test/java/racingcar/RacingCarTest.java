package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @Test
    void input_자동차의_이름과_주행거리_출력(){
        Car pobi = new RacingCar("pobi");

        assertThat(pobi.toString()).isEqualTo("pobi : ");
    }

    @Test
    void input_자동차의_4미만의_수를_받아_주행거리_그대로_반환(){
        Car pobi = new RacingCar("pobi");
        pobi.moveCar(3);

        assertThat(pobi.toString()).isEqualTo("pobi : ");
    }
}