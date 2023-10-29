package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.TestUtil.setInput;

import org.junit.jupiter.api.Test;
import racingcar.model.GameCount;
import racingcar.view.InputView;

class GameCountInputTest {


    InputView inputView = new InputView();

    @Test
    void 정상적인_횟수_입력() {
        // given
        String input = "5";
        setInput(input);

        boolean expected = false;

        // when
        GameCount gameCount = GameCount.from(inputView.askGameCount());

        // then
        assertThat(gameCount.isGameOver()).isEqualTo(expected);
    }
}
