package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    void 문자열로_자동차를_생성할_수_있다() {
        // given
        String name = "ejae";

        // when
        RacingCar racingCar = new RacingCar(name);

        // then
        assertEquals(name, racingCar.getName());
    }

    @Test
    void 생성된_자동차의_위치는_0이다() {
        // given
        String name = "ejae";

        // when
        RacingCar racingCar = new RacingCar(name);

        // then
        assertEquals(0, racingCar.getPosition());
    }

    @Test
    void 이름이_같으면_같은_자동차다() {
        // given
        String name = "ejae";

        // when
        RacingCar racingCarA = new RacingCar(name);
        RacingCar racingCarB = new RacingCar(name);

        // then
        assertEquals(racingCarA, racingCarB);
    }

    @Test
    void 전진_기능이_true를_반환하면_자동차는_움직일_수_있다() {
        // given
        String name = "ejae";
        RacingCar racingCar = new RacingCar(name);

        // when
        RacingCar relocatedracingCar = racingCar.move(() -> true);

        // then
        assertEquals(1, relocatedracingCar.getPosition());
    }

    @Test
    void 전진_기능이_false를_반환하면_자동차는_움직일_수_없다() {
        // given
        RacingCar racingCar = new RacingCar("ejae");

        // when
        RacingCar relocatedracingCar = racingCar.move(() -> false);

        // then
        assertEquals(0, relocatedracingCar.getPosition());
    }
}