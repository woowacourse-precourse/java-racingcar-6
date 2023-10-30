package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputNumberOfAttemptsTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    @DisplayName("유효한 시도 횟수 입력")
    void testValidNumberOfAttempts() {
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputNumberOfAttempts inputNumberOfAttempts = new InputNumberOfAttempts();

        int numberOfAttempts = inputNumberOfAttempts.getNumberOfAttempts();

        assertThat(numberOfAttempts).isEqualTo(5);
    }

    @Test
    @DisplayName("유효하지 않은 시도 횟수 입력")
    void testInvalidNumberOfAttempts() {
        String input = "invalid";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputNumberOfAttempts inputNumberOfAttempts = new InputNumberOfAttempts();

        assertThatThrownBy(() -> inputNumberOfAttempts.getNumberOfAttempts())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("범위를 벗어난 시도 횟수 입력")
    void testOutOfRangeNumberOfAttempts() {
        String input = "-5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputNumberOfAttempts inputNumberOfAttempts = new InputNumberOfAttempts();

        assertThatThrownBy(() -> inputNumberOfAttempts.getNumberOfAttempts())
                .isInstanceOf(IllegalArgumentException.class);
    }
}