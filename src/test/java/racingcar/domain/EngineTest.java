package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EngineTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
            1, false
            3, false
            4, true
            """)
    void 제공받은_숫자에_따라_적절한_boolean을_반환한다(int number, boolean expected) {
        Engine engine = new Engine(() -> number);

        boolean actual = engine.getAsBoolean();

        assertThat(actual).isEqualTo(expected);
    }
}
