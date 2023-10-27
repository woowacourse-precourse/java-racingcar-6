package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FixedCarEngineTest {

    @ParameterizedTest
    @CsvSource(value = {"true", "false"})
    void startTest(boolean move) {
        FixedCarEngine fixedCarEngine = new FixedCarEngine(move);
        boolean canMove = fixedCarEngine.isStart();
        assertThat(canMove).isEqualTo(move);
    }
}
