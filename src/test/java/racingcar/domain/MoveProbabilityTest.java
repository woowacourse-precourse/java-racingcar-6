package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoveProbabilityTest {

    @ParameterizedTest
    @DisplayName("[false 를 받는 경우] canMoveForward 테스트")
    @ValueSource(ints = {0, 1, 2, 3})
    void falseCase(int number) {
        //given

        //when
        MoveProbability probability = MoveProbability.getInstance(new TestNumberGenerator(number));
        boolean result = probability.canMoveForward();

        Assertions.assertThat(result).isEqualTo(false);
    }

    @ParameterizedTest
    @DisplayName("[true 를 받는 경우] canMoveForward 테스트")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void trueCase(int number) {
        //given

        //when
        MoveProbability probability = MoveProbability.getInstance(new TestNumberGenerator(number));
        boolean result = probability.canMoveForward();

        Assertions.assertThat(result).isEqualTo(true);
    }

    static class TestNumberGenerator implements NumberGenerator {

        public int number;

        public TestNumberGenerator(int number) {
            this.number = number;
        }

        @Override
        public int generate() {
            return number;
        }
    }
}