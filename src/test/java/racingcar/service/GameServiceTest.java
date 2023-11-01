package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {
    private static GameService gameService;
    private static Game game;

    @BeforeEach
    void initEach(){
        gameService = new GameService();
        game = new Game();
    }

    @Test
    void 시도횟수_길이_예외_발생(){
        //given
        final String input = "55";
        final String input2 = "";

        //when

        //then
        assertThatThrownBy(() -> gameService.setAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("한 자리의 숫자만 입력 가능합니다.");

        assertThatThrownBy(() -> gameService.setAttempts(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("한 자리의 숫자만 입력 가능합니다.");
    }

    @Test
    void 시도횟수_문자_예외_발생(){
        //given
        final String input = "a";

        //when

        //then
        assertThatThrownBy(() -> gameService.setAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }

    @Test
    void 시도횟수_0_예외_발생(){
        //given
        final String input = "0";

        //when

        //then
        assertThatThrownBy(() -> gameService.setAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1이상의 숫자만 입력 가능합니다.");
    }

    @Test
    void 시도횟수_입력_테스트(){
        //given
        final String input = "5";

        //when
        int attempts = gameService.setAttempts(input);


        //then
        assertThat(attempts).isEqualTo(5);
    }
}