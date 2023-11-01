package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @Test
    @DisplayName("If Name Exceeds 5 Characters, Throw Exception")
    void 이름의_길이가_5글자를_넘을_경우_에러_발생() {
        Assertions.assertThatThrownBy(() -> new Name("abcedf"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5글자 이하만 가능합니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "    "})
    @DisplayName("If Car Name Is Blank, Throw Exception")
    void 이름이_공백일_경우_에러_발생(String carName) {
        Assertions.assertThatThrownBy(() -> new Name(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없습니다");
    }
}
