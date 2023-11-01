package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ExceptionMessage.INVALID_CAR_NAME_LENGTH;
import static racingcar.constant.TestConstants.MOVING_FORWARD;
import static racingcar.constant.TestConstants.NAME_EXCEEDS_LENGTH_LIMIT;
import static racingcar.constant.TestConstants.NAME_UNDER_LENGTH_LIMIT;
import static racingcar.constant.TestConstants.STOP;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 지정한_길이를_초과한_이름의_자동차_생성_시_예외_발생() {
        assertThatThrownBy(() -> 자동차_생성(NAME_EXCEEDS_LENGTH_LIMIT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_CAR_NAME_LENGTH);
    }

    @Test
    void 지정한_길이를_만족하는_이름의_자동차_정상_생성() {
        assertThatCode(() -> 자동차_생성(NAME_UNDER_LENGTH_LIMIT)).doesNotThrowAnyException();
    }

    @Test
    void 지정한_값을_넘는_랜덤_값이_주어지면_포지션_증가() {
        Car car = 자동차_생성(NAME_UNDER_LENGTH_LIMIT);
        assertRandomNumberInRangeTest(
                () -> {
                    car.attempt();
                    assertThat(car.getPosition()).isEqualTo(1);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 지정한_값_미만_랜덤_값이_주어지면_포지션_유지() {
        Car car = 자동차_생성(NAME_UNDER_LENGTH_LIMIT);
        assertRandomNumberInRangeTest(
                () -> {
                    car.attempt();
                    assertThat(car.getPosition()).isEqualTo(0);
                },
                STOP
        );
    }

    @Test
    void 포지션에_맞는_출력값_반환() {
        Car car = 자동차_생성(NAME_UNDER_LENGTH_LIMIT);

        assertRandomNumberInRangeTest(
                () -> {
                    car.attempt();
                    assertThat(car.toString())
                            .isEqualTo(String.format("car : -"));
                },
                MOVING_FORWARD
        );
    }

    private Car 자동차_생성(String name) {
        return new Car(name);
    }
}