package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGame;
import racingcar.util.Validation;

public class RacingGameTest {

    @Test
    void convertStringToIntTest_문자열이_숫자로_변환가능_하면_숫자_리턴() {
        String input = "5";
        int result;
        RacingGame racingGame = new RacingGame();

        result = racingGame.convertStringToInt(input);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void convertStringToIntTest_문자열이_숫자로_변환못할_경우_예외_발생() {
        String input = "hoon";
        RacingGame racingGame = new RacingGame();

        assertThatThrownBy(() -> racingGame.convertStringToInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
