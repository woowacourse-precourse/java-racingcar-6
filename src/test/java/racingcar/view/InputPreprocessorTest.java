package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class InputPreprocessorTest {

    private InputPreprocessor preprocessor;

    @BeforeEach
    void setUp() {
        preprocessor = new InputPreprocessor();
    }

    @Test
    void splitInputByComma() {
        // given
        String input = "car1,car2,car3";

        // when
        String[] result = preprocessor.splitInputByComma(input);

        // then
        assertThat(result).containsExactly("car1", "car2", "car3");
    }

    @Test
    void trimInput() {
        // given
        String input = "   car1  ";

        // when
        String result = preprocessor.trimInput(input);

        // then
        assertThat(result).isEqualTo("car1");
    }
}
