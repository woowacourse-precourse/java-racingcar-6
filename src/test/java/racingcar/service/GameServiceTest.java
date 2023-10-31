package racingcar.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameServiceTest {
    private final GameService service = new GameService();

    @Test
    void 이동_판정_허가() {
        Integer number = 8;

        boolean checked = service.checkMovePossible(number);

        assertThat(checked).isTrue();
    }

    @Test
    void 이동_판정_실패() {
        Integer number = 2;

        boolean checked = service.checkMovePossible(number);

        assertThat(checked).isFalse();
    }

    @Test
    void 우승자_위치_반환() {
        Integer[] positions = new Integer[10];

        for (int i = 0; i < 10; i++) {
            positions[i] = i;
        }

        Integer winnerPosition = service.getWinnerPosition(positions);

        assertThat(winnerPosition).isEqualTo(9);
    }
}