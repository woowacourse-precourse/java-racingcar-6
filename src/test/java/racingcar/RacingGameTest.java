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
    void 차_이름_예외_처리() {
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
}