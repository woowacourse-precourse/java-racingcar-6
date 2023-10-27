package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.function.IntSupplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarRandomMovingStrategyTest {

    @Nested
    @DisplayName("차 이동 여부 테스트")
    class generateBooleanTest {

        @ParameterizedTest(name = "랜덤 숫자가 {0}일 경우 이동 여부 : {1}")
        @CsvSource({"0,false", "3,false", "4,true", "9,true"})
        @DisplayName("생성되는 랜덤 값에 따라 이동 여부를 제공할 수 있다")
        void getAsBooleanTest(int number, boolean expected) {
            CarRandomMovingStrategy strategy = CarRandomMovingStrategy.from(new FixedNumberGenerator(number));

            boolean actual = strategy.getAsBoolean();

            assertThat(actual).isEqualTo(expected);
        }

        @ParameterizedTest(name = "랜덤 숫자 : {0}")
        @CsvSource({"-1", "10"})
        @DisplayName("생성되는 랜덤 값이 범위를 벗어날 경우, 예외를 던진다")
        void getAsBooleanTest_whenRandomNumberIsOutOfRange(int number) {
            CarRandomMovingStrategy strategy = CarRandomMovingStrategy.from(new FixedNumberGenerator(number));

            assertThatThrownBy(strategy::getAsBoolean)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("움직임을 판단하는데 문제가 생겼습니다, 랜덤 값 : " + number);
        }
    }

    static class FixedNumberGenerator implements IntSupplier {

        private final int fixedNumber;

        private FixedNumberGenerator(int number) {
            this.fixedNumber = number;
        }

        @Override
        public int getAsInt() {
            return fixedNumber;
        }
    }
}