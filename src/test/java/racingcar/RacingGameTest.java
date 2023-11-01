package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.Arrays;
import java.util.List;
import java.io.ByteArrayInputStream;

public class RacingGameTest {
    private RacingGameView view;
    private ByteArrayInputStream input;

    @Test
    public void 게임_라운드_수_예외_테스트() {
        assertThatThrownBy(() -> new RacingGame(Arrays.asList("luda", "mori"), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 우승자_출력_테스트() {
        RacingGame game = new RacingGame(Arrays.asList("luda", "mori"), 2);
        List<String> winners = game.getWinners();
        assertThat(winners).contains("luda", "mori");
    }

    @Test
    public void 시도_회수_입력_테스트() {
        view = new RacingGameView();
        input = new ByteArrayInputStream("5\n".getBytes());
        System.setIn(input);
        assertThat(view.requestRounds()).isEqualTo(5);
    }
}
