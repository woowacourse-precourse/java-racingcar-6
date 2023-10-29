package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 도메인 객체에")
class RacingCarTest {

    @Test
    @DisplayName("이동을 요청하면 움직인 거리가 1 늘어나는가")
    void move() {
        // given
        final RacingCar racingCar = new RacingCar(new Name("hello"));
        final int before = racingCar.moveDistance();

        // when
        racingCar.move();

        // then
        assertThat(racingCar.moveDistance()).isEqualTo(before + 1);
    }

    @Test
    void toResultMessage() {
        // given
        final String hello = "hello";
        final RacingCar racingCar = new RacingCar(new Name(hello));
        racingCar.move();

        // when
        final String result = racingCar.toResultMessage();

        // then
        assertThat(result).contains(hello, " : ", "-").doesNotContain("--");
    }

    @Test
    void hasSameDistance() {}

    @Test
    void equals() {}
}
