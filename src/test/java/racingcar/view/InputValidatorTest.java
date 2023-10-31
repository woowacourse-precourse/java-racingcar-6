package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.EmptyInputException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    void init() {
        inputValidator = new InputValidator();
    }

    @ValueSource(strings = {"", " "})
    @ParameterizedTest
    void 빈값을_넣으면_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> inputValidator.validateInput(input))
                .isInstanceOf(EmptyInputException.class);
    }
}
