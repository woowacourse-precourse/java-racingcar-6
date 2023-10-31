package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.vo.RacingCar;

class RacingLogicTest {

    @Test
    void 숫자가_0에서_9사이_랜덤숫자인지() {
        int randomNumber = RacingLogic.makeRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    void 레이싱카가_전진할때() {
        RacingCar racingCar = new RacingCar("car");
        RacingLogic.isPlusDistance(4, racingCar);
        assertThat(racingCar.getDistance()).isEqualTo(1);
    }

    @Test
    void 레이싱카가_움직이지_않을때() {
        RacingCar racingCar = new RacingCar("car");
        RacingLogic.isPlusDistance(0, racingCar);
        assertThat(racingCar.getDistance()).isEqualTo(0);
    }

}