package racingcar.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NameValidationTest {

    @Test
    void 올바른_형식의_입력인지_검증한다() {
        String input = "jason,abby,";

        NameValidation nameValidation = new NameValidation(input);
        assertThatThrownBy(nameValidation::isCorrectPattern)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("ERROR: 허용되지 않은 입력입니다");
    }
}