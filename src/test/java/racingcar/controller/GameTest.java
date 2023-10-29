package racingcar.controller;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingcarGame;
import racingcar.domain.dto.InitDTO;

class GameTest {
    private static final String RIGHT_INPUT_ABOUT_NAMES = "toto,hoho,koko";
    private static final String RIGHT_INPUT_ABOUT_ROUNDS = "4";
    @Test
    void 조건에_맞는_차량이름과_실행횟수_입력(){
        Assertions.assertThatCode(() -> {
                    InitDTO initDTO = new InitDTO(RIGHT_INPUT_ABOUT_NAMES, RIGHT_INPUT_ABOUT_ROUNDS);

                    new RacingcarGame(initDTO);
                })
                .doesNotThrowAnyException();

    }

    @Test
    void 차량이름의_크기_5초과(){
        // given
        String names = "tototo,hoho";

        // then
        Assertions.assertThatThrownBy(() ->
            new RacingcarGame(new InitDTO(names, RIGHT_INPUT_ABOUT_ROUNDS))
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 5글자 이하 여야 합니다.");
    }

    @Test
    void 실행횟수_0이하(){
        // given
        String rounds = "-1";

        // then
        Assertions.assertThatThrownBy(() -> {
            InitDTO initDTO = new InitDTO(RIGHT_INPUT_ABOUT_NAMES, rounds);
            new RacingcarGame(initDTO);
        })

    }

    @Test
    void 실행횟수에_문자_포함(){

    }

}