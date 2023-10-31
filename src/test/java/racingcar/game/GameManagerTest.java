package racingcar.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static racingcar.game.constant.CarExceptionMessage.*;

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

    private void assertCarExceptionCase(String carNames, String errorMessage) {
        Assertions.assertThatThrownBy(() -> manager.setCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

}