package racingcar.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundControllerTest {

    @Test
    public void 유효한_숫자_테스트() {
        String input = "5";
        int result = RoundController.getRoundFromUser(input);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 숫자에_대한_예외_처리_문자_입력() {
        String input = "five";

        assertThatThrownBy(() -> RoundController.getRoundFromUser(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
