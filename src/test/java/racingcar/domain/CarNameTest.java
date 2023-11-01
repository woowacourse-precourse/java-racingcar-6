package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.common.response.ErrorCode.*;

@DisplayName("자동차 이름 검증")
class CarNameTest {

    @Test
    void 자동차_이름_null_예외() {
        // when
        // then
        assertThatThrownBy(() -> new CarName(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_NULL.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "myName"})
    void 자동차_이름_글자_예외(String name) {
        // when
        // then
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_INVALID_LENGTH.getMessage());
    }

    @Test
    void 자동차_이름_공백_포함_예외() {
        // given
        String name = "c a r";

        // when
        // then
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_CONTAIN_SPACE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "car", "자동차", "myCar"})
    void 자동차_이름_생성(String name) {
        // when
        CarName result = new CarName(name);

        // then
        assertThat(result).isNotNull();
    }
}