package racingcar.car;

import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    void input_자동차의_4이상의_수를_받아_주행거리_반환(){
        Car pobi = new RacingCar("pobi");
        pobi.moveCar(4);
        pobi.moveCar(9);
        pobi.moveCar(6);

        assertThat(pobi.toString()).isEqualTo("pobi : ---");
    }

    @Test
    void input_자동차가_세번의_이동할_시도를_하고_주행거리_반환(){
        Car pobi = new RacingCar("pobi");
        pobi.moveCar(0);
        pobi.moveCar(4);
        pobi.moveCar(8);

        assertThat(pobi.toString()).isEqualTo("pobi : --");
    }
}