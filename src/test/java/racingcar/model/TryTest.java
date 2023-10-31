package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TryTest {
    @ParameterizedTest
    @CsvSource({"1","2","3","100"})
    void 횟수_입력(int number) {
        Try coin = new Try(number);
        int result = coin.get();
        assertThat(result).isEqualTo(number);
    }

    @ParameterizedTest
    @CsvSource({"-1", "0"})
    void 횟수_입력_예외처리(int number) {
        assertThatThrownBy(() -> new Try(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

}