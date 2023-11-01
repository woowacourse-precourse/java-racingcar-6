package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @Test
    @DisplayName("이름 생성 테스트")
    void init_ValidName() {
        // given
        String name = "beom";

        // when
        Name myName = new Name(name);

        // then
        assertThat(myName).isNotNull();
        assertThat(myName.toString()).hasToString(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"long name ", "", "   "})
    @DisplayName("제대로 된 이름이 입력으로 들어오지 않은 경우")
    void init_InvalidName(String name) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Name(name)).isInstanceOf(IllegalArgumentException.class);
    }
}
