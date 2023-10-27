package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import racingcar.GameModel;

public class GameModelTest {

    @Test
    @Disabled
    void 랜덤_숫자_검증테스트() {
        int result = GameModel.generateRandomNumber();

        assertThat(result).isBetween(0, 9);
    }

    @Test
    void 고_스톱_Test() {
        boolean result = GameModel.decideGoAndStop();

        assertThat(result).isTrue();
    }

}
