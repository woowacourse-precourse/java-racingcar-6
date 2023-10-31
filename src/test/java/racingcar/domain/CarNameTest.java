package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    private static final String VALID_CAR_NAME = "pobi";
    private static final String EMPTY_CAR_NAME = "";
    private static final String LONG_CAR_NAME = "qwertr";

    @Test
    void 유효한_자동차_이름_생성_성공() {
        CarName carName = new CarName(VALID_CAR_NAME);
        assertThat(carName.getName()).isEqualTo(VALID_CAR_NAME);
    }

    @Test
    void 빈_자동차_이름_생성시_에러() {
        assertThatThrownBy(() -> new CarName(EMPTY_CAR_NAME))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 잘못되었습니다.");
    }

    @Test
    void 유효한_자동차_이름_생성() {
        assertThatThrownBy(() -> new CarName(LONG_CAR_NAME))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 5자를 초과입니다.");
    }
}