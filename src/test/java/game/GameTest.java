package game;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Game;
import racingcar.service.GameService;

public class GameTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final GameService gameService = new GameService();


    @Test
    void 전진_정지_단위_테스트() {
        Game GAME = gameService.createGame(
            gameService.setupParticipantCars(List.of("jay", "ted")));

        assertRandomNumberInRangeTest(
            () -> {
                for (int i = 0; i < 4; i++) {
                    gameService.controlCar(GAME);
                }
                assertThat(output()).contains("1", "1", "1", "2");
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Override
    protected void runMain() { }
}
