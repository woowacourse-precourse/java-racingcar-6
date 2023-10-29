package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.TestUtil.setInput;

import org.junit.jupiter.api.Test;
import racingcar.model.Race;
import racingcar.view.InputView;

class GameCountInputTest {

    Race race = new Race();
    InputView inputView = new InputView();

    @Test
    void 정상적인_횟수_입력() {
        // given
        String input = "5";
        setInput(input);

        int expected = 5;
        // when
        race.setGameCount(Integer.parseInt(inputView.askGameCount()));

        // then
        assertThat(race.getGameCount()).isEqualTo(expected);
    }
}
