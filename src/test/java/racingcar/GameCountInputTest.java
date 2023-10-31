package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static racingcar.model.race.GameCount.GAME_COUNT_OUT_OF_RANGE;
import static racingcar.util.Validator.NO_DIGIT;
import static util.TestUtil.setInput;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.race.GameCount;
import racingcar.view.InputView;

/**
 * docs/README.md <br/><br/> 요구사항 3, 5 <br/><br/> 3-1. 횟수 입력 <br/> 5-1. 횟수 입력 예외 발생 <br/>
 */
class GameCountInputTest {


    InputView inputView = new InputView();

    @AfterEach
    void closeInput() {
        Console.close();
    }

    @Test
    void 정상적인_횟수_입력() {
        // given
        setInput("5");
        boolean expected = false;

        // when
        GameCount gameCount = GameCount.from(inputView.askGameCount());

        // then
        assertThat(gameCount.isGameOver()).isEqualTo(expected);
    }

    @Test
    void InputView_숫자가_아닐_경우_예외_발생() {
        // given
        setInput("우아한테크코스 6기");

        // when & then
        assertThatThrownBy(() -> inputView.askGameCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NO_DIGIT);
    }

    @Test
    void GameCount_음수_또는_0_입력시_예외_발생() {
        // given
        int count = 0;

        // when & then
        assertThatThrownBy(() -> GameCount.from(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(GAME_COUNT_OUT_OF_RANGE);
    }
}
