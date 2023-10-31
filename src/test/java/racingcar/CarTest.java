package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {
    private static final String NAME_UNDER_LENGTH_LIMIT = "car";
    private static final String NAME_EXCEEDS_LENGTH_LIMIT = "longCar";


    @Test
    void 지정한_길이를_초과한_이름의_자동차_생성_시_예외_발생() {
        Assertions.assertThatThrownBy(() -> new Car(NAME_EXCEEDS_LENGTH_LIMIT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 지정한_길이를_만족하는_이름의_자동차_정상_생성() {
        Car car = new Car(NAME_UNDER_LENGTH_LIMIT);
        Assertions.assertThat(car.getName())
                .isEqualTo(NAME_UNDER_LENGTH_LIMIT);
    }


}