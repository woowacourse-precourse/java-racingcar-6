package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class RacingCarGameTest {
    private final RacingCarGame racingCarGame = new RacingCarGame();

    @Test
    void 이동_횟수_입력_예외_처리() {
        String number = "1a";

        assertThatThrownBy(() -> racingCarGame.toInt(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자 이외의 값을 입력했습니다.");
    }
}