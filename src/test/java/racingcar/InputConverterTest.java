package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.InputConverter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputConverterTest {

    private InputConverter inputConverter = new InputConverter();

    @ParameterizedTest
    @CsvSource(value = {"'3',3", "'10',10", "'5',5"})
    void covertTimes에_문자열주면_정수로반환(String times, int expected) {
        int result = inputConverter.covertTimes(times);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"p1", "1s", "s"})
    void covertTimes에_올바르지않은_문자열주면_예외반환(String unTimes) {
        assertThatThrownBy(() -> inputConverter.covertTimes(unTimes))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkMin_0추면_예외반환(){
        assertThatThrownBy(() -> inputConverter.covertTimes("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}