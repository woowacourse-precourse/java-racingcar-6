package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {

    @Test
    void 이름으로_자동차_생성() {
        String carName = "poby";
        RacingCar car = new RacingCar(carName);

        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    void 이름이_5글자가_넘으면_오류() {
        String carName = "name_length_over_5";

        assertThatThrownBy(() -> new RacingCar(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 뽑은_숫자가_4이상이면_움직임() {
        int number = 4;
        RacingCar car = new RacingCar("car");

        car.moveForward(number);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 뽑은_숫자가_4미만이면_멈춤() {
        int number = 3;
        RacingCar car = new RacingCar("car");

        car.moveForward(number);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}