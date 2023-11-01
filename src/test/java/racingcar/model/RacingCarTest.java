package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ErrorMessage.CAR_NAME_OVER_MAX_LENGTH;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class RacingCarTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STAY = 3;

    @Test
    void 자동차의_이름은_공백포함_5자이하여야_한다() {
        assertThatThrownBy(() -> new RacingCar("5자이상 자동차 이름"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_OVER_MAX_LENGTH);
    }

    @Test
    void 생성된_랜덤값에_따라_자동차를_전진시킬_수_있다() {
        RacingCar car = new RacingCar("car1");
        assertRandomNumberInRangeTest(
                () -> {
                    car.moveOrStay();
                },MOVING_FORWARD
        );
        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    void 생성된_랜덤값에_따라_자동차를_정지시킬_수_있다() {
        RacingCar car = new RacingCar("car1");
        assertRandomNumberInRangeTest(
                () -> {
                    car.moveOrStay();
                },STAY
        );
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @Test
    void 자동차의_이름과_위치를_조합해_적절한_출력형태를_만들_수_있다() {
        RacingCar car = new RacingCar("car1");
        assertRandomNumberInRangeTest(
                () -> {
                    car.moveOrStay();
                    car.moveOrStay();
                    car.moveOrStay();
                },STAY,MOVING_FORWARD,MOVING_FORWARD
        );
        assertThat(car.toString()).isEqualTo("car1 : --");
    }

    @Override
    protected void runMain() {

    }
}