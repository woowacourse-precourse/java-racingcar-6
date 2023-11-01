package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validator.InputValidator;

public class InputValidatorTest {

    @DisplayName("getCarNameList must be fail when input name has invalid length")
    @ParameterizedTest
    @ValueSource(strings = {"", "banana"})
    void getCarNameListMustBeFailWhenNameLengthIsInvalid(String name) {
        assertThatThrownBy(() -> InputValidator.verifyCarNames(Arrays.asList("pobi", name)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("getCarNameList must be fail when input has duplicated name")
    @Test
    void getCarNameListMustBeFailWhenContainsDuplicateName() {
        assertThatThrownBy(() -> InputValidator.verifyCarNames(Arrays.asList("pobi", "pobi", "jun")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
