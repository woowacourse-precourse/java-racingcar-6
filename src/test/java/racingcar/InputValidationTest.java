package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidationTest {
    private InputValidation inputValidation;

    @BeforeEach
    void setUp() {
        inputValidation = new InputValidation();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni/jun", "pobi,woni jun", "pobi,woni.jun", "pobi-woni,jun", "pobi_woni,jun"})
    void 구분자에_대한_예외_처리(String name) {
        assertThatThrownBy(() -> inputValidation.validateInputCorrectSeparator(name))
                .isInstanceOf(IllegalArgumentException.class);
    }


}