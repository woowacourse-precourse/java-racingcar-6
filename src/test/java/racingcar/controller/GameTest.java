package racingcar.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingcarGame;
import racingcar.domain.dto.InitDTO;

class GameTest {
    private static final String RIGHT_INPUT_ABOUT_NAMES = "toto,hoho,koko";
    private static final String RIGHT_INPUT_ABOUT_ROUNDS = "4";
    @Test
    void 조건에_맞는_차량이름과_실행횟수_입력(){
        // given
        InitDTO initDTO = new InitDTO(RIGHT_INPUT_ABOUT_NAMES, RIGHT_INPUT_ABOUT_ROUNDS);

        // then
        Assertions.assertThatCode(() -> new RacingcarGame(initDTO))
                .doesNotThrowAnyException();

    }

    @Test
    void 차량이름의_크기_5초과(){
        // given
        String names = "tototo,hoho";

    }

    @Test
    void 실행횟수_0이하(){

    }

    @Test
    void 실행횟수에_문자_포함(){

    }

}