package racingcar.Model;
import org.junit.jupiter.api.Test;
import racingcar.View.RacingGameView;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RacingGameTest {
    private RacingGameView view;
    private ByteArrayInputStream input;

    @Test
    public void 게임_라운드_수_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingGame(Arrays.asList("luda", "mori"), 0);
        });
    }

    @Test
    public void 우승자_출력_테스트() {
        RacingGame game = new RacingGame(Arrays.asList("luda", "mori"), 2);
        List<String> winners = game.getWinners();
        assertTrue(winners.contains("luda") || winners.contains("mori"));
    }

    @Test
    public void 시도_회수_입력_테스트() {
        view = new RacingGameView();
        input = new ByteArrayInputStream("5\n".getBytes());
        System.setIn(input);
        assertEquals(5, view.requestRounds());
    }

}
