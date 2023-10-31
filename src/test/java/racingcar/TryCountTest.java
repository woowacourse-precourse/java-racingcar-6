package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryCountTest {

    @CsvSource({
            "1,1",
            "0,0",
    })
    @ParameterizedTest
    void 문자열로_값_초기화_성공(String given, Integer expected) {
        TryCount givenTryCount = TryCount.fromString(given);
        assertThat(givenTryCount.getCount()).isEqualTo(expected);
    }

    @CsvSource({
            "-1",
            "zero",
    })
    @ParameterizedTest
    void 문자열로_값_초기화_실패(String given) {
        assertThatThrownBy(() -> TryCount.fromString(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @CsvSource({
            "1,1",
            "0,0",
    })
    @ParameterizedTest
    void 정수로_값_초기화_성공(Integer given, Integer expected) {
        TryCount givenTryCount = TryCount.fromInteger(given);
        assertThat(givenTryCount.getCount()).isEqualTo(expected);
    }

    @CsvSource({
            "-1",
            "-123",
    })
    @ParameterizedTest
    void 정수로_값_초기화_실패(Integer given) {
        assertThatThrownBy(() -> TryCount.fromInteger(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @CsvSource({
            "0, true",
            "1, false",
    })
    @ParameterizedTest
    void 카운트가_끝났는지_확인(String given, boolean expected) {
        TryCount givenTryCount = TryCount.fromString(given);
        assertThat(givenTryCount.isFinished()).isEqualTo(expected);
    }

    @CsvSource({
            "1, 0",
            "0, 0",
    })
    @ParameterizedTest
    void 카운트_소비(String given, Integer expected) {
        TryCount givenTryCount = TryCount.fromString(given);
        givenTryCount.consumeTry();
        assertThat(givenTryCount.getCount()).isEqualTo(expected);
    }
}
