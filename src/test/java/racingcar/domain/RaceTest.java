package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    @Test
    @DisplayName("No Exception")
    void Race_정상_생성() {
        Assertions.assertThatCode(() -> {
            new Race("12");
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("If Attempt Is Blank, Throw Exception")
    void 시도_회수가_공백일_경우_예외_발생() {
        Assertions.assertThatThrownBy(() -> new Race(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 회수는 공백일 수 없습니다.");

        Assertions.assertThatThrownBy(() -> new Race("  "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 회수는 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("If Not Positive Integer, Throw Exception")
    void 시도_회수가_양의_정수가_아닐_경우_예외_발생() {
        Assertions.assertThatThrownBy(() -> new Race("-12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 회수는 양의 정수만 가능합니다.");

        Assertions.assertThatThrownBy(() -> new Race("1.2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 회수는 양의 정수만 가능합니다.");

        Assertions.assertThatThrownBy(() -> new Race("1a2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 회수는 양의 정수만 가능합니다.");

        Assertions.assertThatThrownBy(() -> new Race("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 회수는 양의 정수만 가능합니다.");
    }
}