package racingcar.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class RacingGameTest {
    private RacingGame racingGame;
    private List<String> carNames;
    private int tryCount;

    @BeforeEach
    public void setup() {
        carNames = Arrays.asList("car1", "car2", "car3");
        tryCount = 5;
        racingGame = new RacingGame(carNames, tryCount);
    }

    @Test
    public void testPlayRound() {
        racingGame.playRound();
        // 어떤 자동차가 움직였는지는 랜덤이므로, 특정 결과를 예상하기는 어렵습니다.
        // 따라서 이 테스트는 자동차들이 에러 없이 움직이는 것만을 확인합니다.
        assertNotNull(racingGame.getCars());
    }

    @Test
    public void testGetWinners() {
        for (int i = 0; i < tryCount; i++) {
            racingGame.playRound();
        }
        List<Car> winners = racingGame.getWinners();
        assertNotNull(winners);
        assertTrue(winners.size() > 0);
    }
}
