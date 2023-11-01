package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @Test
    @DisplayName("이름 생성 테스트")
    void init_ValidName() {
        // given
        String name = "pobi";
        // when
        CarName carName = new CarName(name);
        // then
        assertThat(carName).isNotNull();
        assertThat(carName.toString()).hasToString(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"!$!$@abc  ", "", "   "})
    @DisplayName("제대로 된 이름이 입력으로 들어오지 않은 경우")
    void init_InvalidName(String name) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new CarName(name)).isInstanceOf(IllegalArgumentException.class);
    }
}