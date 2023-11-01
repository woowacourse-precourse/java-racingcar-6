package racingcar.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static racingcar.game.constant.CarExceptionMessage.*;
import static racingcar.game.constant.RoundExceptionMessage.*;

class GameManagerTest {

    private GameManager manager;

    @BeforeEach
    void beforeEach() {
        manager = new GameManager();
    }

    @AfterEach
    void afterEach() {
        manager = null;
    }

    @Test
    void 자동차_이름_개수가_1이상이_아니면_예외_발생() {
        assertCarExceptionCase("", OUT_OF_LENGTH_RANGE);
    }

    @Test
    void 자동차_이름_개수가_10이하가_아니면_예외_발생() {
        assertCarExceptionCase("a,b,c,d,e,f,g,h,i,j,k", OUT_OF_COUNT_RANGE);
    }

    @Test
    void 이동_횟수가_정수가_아니면_예외_발생() {
        assertRoundExceptionCase("bbb", NOT_INTEGER);
    }

    @Test
    void 이동_횟수가_1이상_10이하가_아니면_예외_발생() {
        assertRoundExceptionCase("0", OUT_OF_RANGE);
        assertRoundExceptionCase("101", OUT_OF_RANGE);
    }

    @Test
    void 총_이동_횟수만큼_게임을_진행() {
        manager.setCars("hwang,jung,seop");
        manager.setRound("6");

        int raceCount=0;
        while (manager.isGameOngoing()) {
            manager.raceOneRound();
            raceCount++;
        }

        assertThat(raceCount).isEqualTo(6);
    }

    private void assertCarExceptionCase(String carNames, String errorMessage) {
        assertThatThrownBy(() -> manager.setCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    private void assertRoundExceptionCase(String movingCount, String errorMessage) {
        assertThatThrownBy(() -> manager.setRound(movingCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

}