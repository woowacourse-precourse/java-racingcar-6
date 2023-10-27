package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class AskHowManyPlayGameTest {
    @Test
    void askHowManyPlayGame_정상값_테스트() {
        String input = "10";
        AskHowManyPlayGame askHowManyPlayGame = new AskHowManyPlayGame();

        assertThat(askHowManyPlayGame.askHowManyPlayGame(input)).isEqualTo(Integer.parseInt(input));
    }

    @Test
    void askHowManyPlayGame_에러_테스트() {
        String input = "열번";
        AskHowManyPlayGame askHowManyPlayGame = new AskHowManyPlayGame();

        assertThatThrownBy(() -> askHowManyPlayGame.askHowManyPlayGame(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
