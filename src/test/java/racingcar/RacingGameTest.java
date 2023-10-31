package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {
    private static RacingGame racingGame;

    @BeforeEach
    void initEach(){
        racingGame = new RacingGame();
    }

    @Test
    void 차_이름_글자수_예외_발생() {
        //given
        final String input = "pobi,javaji";

        //when

        //then
        assertThatThrownBy(() -> racingGame.inputCarsName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 차_이름_입력_테스트() {
        //given
        final String input = "pobi,woni";

        //when
        final List<String> cars = racingGame.inputCarsName(input);

        //then
        assertThat(cars).contains("woni", "pobi");
        assertThat(cars).containsExactly("pobi","woni");
    }

    @Test
    void 시도횟수_길이_예외_발생(){
        //given
        final String input = "55";
        final String input2 = "";

        //when

        //then
        assertThatThrownBy(() -> racingGame.inputAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("한 자리의 숫자만 입력 가능합니다.");

        assertThatThrownBy(() -> racingGame.inputAttempts(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("한 자리의 숫자만 입력 가능합니다.");
    }

    @Test
    void 시도횟수_문자_예외_발생(){
        //given
        final String input = "a";

        //when

        //then
        assertThatThrownBy(() -> racingGame.inputAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }

    @Test
    void 시도횟수_0_예외_발생(){
        //given
        final String input = "0";

        //when

        //then
        assertThatThrownBy(() -> racingGame.inputAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 9사이의 숫자만 입력 가능합니다.");
    }

    @Test
    void 시도횟수_입력_테스트(){
        //given
        final String input = "5";

        //when
        final int attempts = racingGame.inputAttempts(input);

        //then
        assertThat(attempts).isEqualTo(5);
    }

}