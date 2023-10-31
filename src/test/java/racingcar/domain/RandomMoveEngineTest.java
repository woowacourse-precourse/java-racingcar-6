package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomMoveEngineTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
            -1, false
            3, false
            4, true
            9, true
            """)
    void 랜덤하게_고른_숫자가_4_이상이면_true를_반환한다(int number, boolean expected) {
        MockRandomMoveEngine randomMoveEngine = new MockRandomMoveEngine();
        randomMoveEngine.number = number;

        boolean actual = randomMoveEngine.getAsBoolean();

        assertThat(actual).isEqualTo(expected);
    }

    private static class MockRandomMoveEngine extends RandomMoveEngine {
        private int number;

        @Override
        public int getRandomNumber() {
            return number;
        }
    }
}
