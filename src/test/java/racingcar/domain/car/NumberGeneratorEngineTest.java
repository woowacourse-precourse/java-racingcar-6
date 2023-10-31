package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.util.NumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorEngineTest {
    @ParameterizedTest
    @DisplayName("NumberGenerator 엔진은 generator에게 숫자를 뽑아서 4 이상이면 true를 반환한다.")
    @ValueSource(ints = { 4, 5, 6, 7, 8, 9 })
    void number_generator_engine_move_test(int generatedNumber) {
        // given
        NumberGenerator generator = () -> generatedNumber;

        // when
        CarEngine numberGeneratorEngine = new NumberGeneratorEngine(generator);
        boolean moveResult = numberGeneratorEngine.move();

        // then
        assertThat(moveResult).isTrue();
    }

    @ParameterizedTest
    @DisplayName("NumberGenerator 엔진은 generator에게 숫자를 뽑아서 3 이하면 false를 반환한다.")
    @ValueSource(ints = { 0, 1, 2, 3 })
    void number_generator_engine_stop_test(int generatedNumber) {
        // given
        NumberGenerator generator = () -> generatedNumber;

        // when
        CarEngine numberGeneratorEngine = new NumberGeneratorEngine(generator);
        boolean moveResult = numberGeneratorEngine.move();

        // then
        assertThat(moveResult).isFalse();
    }
}
