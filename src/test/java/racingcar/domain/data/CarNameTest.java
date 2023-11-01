package racingcar.domain.data;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarNameTest {

    private static final String VALID_CAR_NAME = "pobi";
    private static final String EMPTY_CAR_NAME = "";
    private static final String LONG_CAR_NAME = "qwertr";

    @Test
    void 유효한_자동차_이름_생성_성공() {
        CarName carName =CarName.from(VALID_CAR_NAME);
        assertThat(carName.getValue()).isEqualTo(VALID_CAR_NAME);
    }

    @Test
    void 빈_자동차_이름_생성시_에러() {
        assertThatThrownBy(() -> CarName.from(EMPTY_CAR_NAME))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 잘못되었습니다.");
    }

    @Test
    void 유효한_자동차_이름_생성() {
        assertThatThrownBy(() -> CarName.from(LONG_CAR_NAME))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 5자를 초과합니다.");
    }
}