package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    @DisplayName("move() 메소드 호출시 거리가 1 증가하는지 판단")
    void Given_RacingCar_When_MovedOne_Then_DistanceIncreasedOne() {
        // given
        RacingCar racingCar = new RacingCar("test");

        // when
        racingCar.move();

        // then
        assertThat(racingCar.getDistance()).isEqualTo(1);
    }
}