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
}