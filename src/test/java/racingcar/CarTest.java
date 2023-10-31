package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {
    private static final String NAME_UNDER_LENGTH_LIMIT = "car";
    private static final String NAME_EXCEEDS_LENGTH_LIMIT = "longCar";
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;


    @Test
    void 지정한_길이를_초과한_이름의_자동차_생성_시_예외_발생() {
        Assertions.assertThatThrownBy(() -> new Car(NAME_EXCEEDS_LENGTH_LIMIT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 지정한_길이를_만족하는_이름의_자동차_정상_생성() {
        Car car = new Car(NAME_UNDER_LENGTH_LIMIT);
        assertThat(car.getName())
                .isEqualTo(NAME_UNDER_LENGTH_LIMIT);
    }

    @Test
    void 지정한_값을_넘는_랜덤_값이_주어지면_포지션_증가() {
        Car car = new Car(NAME_UNDER_LENGTH_LIMIT);
        assertRandomNumberInRangeTest(
                () -> {
                    car.attempt();
                    assertThat(car.getPosition()).isEqualTo(1);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 지정한_값을_미만_랜덤_값이_주어지면_포지션_증가() {
        Car car = new Car(NAME_UNDER_LENGTH_LIMIT);
        assertRandomNumberInRangeTest(
                () -> {
                    car.attempt();
                    assertThat(car.getPosition()).isEqualTo(0);
                },
                STOP
        );
    }
}