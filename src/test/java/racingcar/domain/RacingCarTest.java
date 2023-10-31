package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    void 숫자_0에서_9까지_숫자중에서_4이상이면_전진() {
        // given
        RacingCar racingCar1 = RacingCar.of("name1");
        RacingCar racingCar2 = RacingCar.of("name2");

        // when
        racingCar1.move(3);
        racingCar2.move(4);

        // then
        assertThat(racingCar1.getWinningPoint()).isEqualTo(0);
        assertThat(racingCar2.getWinningPoint()).isEqualTo(1);
    }

    @Test
    void 숫자_0에서_9까지_랜덤으로_하나의_수를_반환() {
        // given
        RacingCar racingCar = RacingCar.of("name");

        // when
        int randomNumber = racingCar.pickRandomNumber();

        // then
        assertThat(randomNumber).isGreaterThanOrEqualTo(0);
        assertThat(randomNumber).isLessThanOrEqualTo(9);
    }
}