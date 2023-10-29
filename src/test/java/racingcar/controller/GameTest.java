package racingcar.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingcarGame;
import racingcar.domain.dto.InitDTO;

class GameTest {
    private static final String RIGHT_INPUT_ABOUT_NAMES = "toto,hoho,koko";
    private static final String RIGHT_INPUT_ABOUT_ROUNDS = "4";

    @Test
    void 조건에_맞는_차량이름과_실행횟수_입력() {
        Assertions.assertThatCode(
                        () -> new RacingcarGame(new InitDTO(RIGHT_INPUT_ABOUT_NAMES, RIGHT_INPUT_ABOUT_ROUNDS)))
                .doesNotThrowAnyException();

    }

    @Test
    void 차량이름의_크기_5초과() {
        // given
        String names = "tototo,hoho";

        // then
        Assertions.assertThatThrownBy(() -> new RacingcarGame(new InitDTO(names, RIGHT_INPUT_ABOUT_ROUNDS)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("자동차의 이름은 5글자 이하 여야 합니다.");
    }

    @Test
    void 실행횟수_0이하() {
        // given
        String rounds = "-1";

        // then
        Assertions.assertThatThrownBy(() -> new RacingcarGame(new InitDTO(RIGHT_INPUT_ABOUT_NAMES, rounds)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("실행 횟수를 양수로 입력해 주세요.");
    }

    @Test
    void 실행횟수에_문자_포함() {
        // given
        String rounds = "d";

        // then
        Assertions.assertThatThrownBy(() -> new RacingcarGame(new InitDTO(RIGHT_INPUT_ABOUT_NAMES, rounds)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 다른 문자를 입력하셨습니다. 실행 횟수를 양수로 입력해 주세요.");
    }

}