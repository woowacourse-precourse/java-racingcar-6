package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @Test
    public void 자동차_이름의_길이가_1보다_작으면_예외_발생() {
        // given
        final String carName = "";

        // then
        Assertions.assertThatThrownBy(() -> new Name(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차_이름의_길이가_5보다_크면_예외_발생() {
        // given
        final String carName = "porsche";

        // then
        Assertions.assertThatThrownBy(() -> new Name(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" pobi", "p obi", "pobi "})
    public void 자동차_이름에_공백이_포함된_경우_예외_발생(String carName) {
        Assertions.assertThatThrownBy(() -> new Name(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}