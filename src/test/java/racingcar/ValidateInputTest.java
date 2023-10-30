package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidateInputTest {

    @ParameterizedTest
    @NullAndEmptySource
    void isNotNullOrEmpty_input이_없거나_공백이면_IllegalArgumentException(String input) {
        assertThatThrownBy(() ->
                ValidateInput.isNotNullOrEmpty(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaa", "12a", "-1", "1.2"})
    void isNumeric_input이_정수형태가_아닌경우_IllegalArgumentException(String input) {
        assertThatThrownBy(() ->
                ValidateInput.isNumeric(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isCarNameDuplicate_이름에_중복이_있으면_IllegalArgumentException() {
        String[] names = new String[]{"name", "name"};
        assertThatThrownBy(() ->
                ValidateInput.isRightCarNames(names)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isWrongLengthNames_이름의_길이범위를_초과하면_IllegalArgumentException() {
        String[] names = new String[]{"longer"};
        assertThatThrownBy(() ->
                ValidateInput.isRightCarNames(names)).isInstanceOf(IllegalArgumentException.class);
    }
}