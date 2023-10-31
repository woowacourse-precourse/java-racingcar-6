package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AttemptsTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 10, 50, 100, 150, 300, 500})
    @DisplayName("유효한 수는 예외를 발생시키지 않는다.")
    void should_NotThrowIllegalArgumentException_When_NumberIsValid(int number) {
        Attempts attempts = new Attempts(number);
        assertThat(attempts).isEqualTo(new Attempts(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {5001, 10000, 100000, 99999999})
    @DisplayName("MAXIMUM_ATTEMPTS를 초과하는 수는 예외를 발생시킨다.")
    void should_ThrowIllegalArgumentException_When_NumberIsOverThanMaximumAttempts(int number) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Attempts(number);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -500, -9999999})
    @DisplayName("0 혹은 음수는 예외를 발생시킨다.")
    void should_ThrowIllegalArgumentException_When_NumberIsZeroOrNegative(int number) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Attempts(number);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"미국", "브라질", "영국", "프랑스", "캐나다", "러시아", "이탈리아", "일본", "멕시코"})
    @DisplayName("문자열은 예외를 발생시킨다.")
    void should_ThrowIllegalArgumentException_When_ParameterIsString(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Attempts(Integer.parseInt(input));
        });
    }

    @Test
    @DisplayName("공백은 예외를 발생시킨다.")
    void should_ThrowIllegalArgumentException_When_ParameterIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Attempts(Integer.parseInt(""));
        });
    }

}
