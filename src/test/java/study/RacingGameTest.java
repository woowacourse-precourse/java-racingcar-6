package study;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingGame;

public class RacingGameTest {

    @Test
    void 자동차이름을_입력하면_쉼표를_기준으로_분리할_수_있다() {
        String input = "pobi,woni";
        RacingGame racingGame = new RacingGame();
        assertThatCode(() -> racingGame.getCars(List.of(input.split(","))));
    }
}
