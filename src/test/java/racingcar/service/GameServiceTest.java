package racingcar.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameServiceTest {

    @Test
    void 우승자_위치_반환() {
        GameService service = new GameService();
        Integer[] positions = new Integer[10];

        for (int i = 0; i < 10; i++) {
            positions[i] = i;
        }

        Integer winnerPosition = service.getWinnerPosition(positions);

        assertThat(winnerPosition).isEqualTo(9);
    }
}