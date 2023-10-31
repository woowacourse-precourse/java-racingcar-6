package racingcar.utilCheck;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RunGame;
import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {
    @DisplayName("전진 못하는 경우")
    @Test
    void notMoveTest() {
        int[] randomInt = {0,1,2,3};
        for (int i: randomInt) {
            assertThat(RunGame.randomMove(i)).isFalse();
        }
    }
    @DisplayName("전진 하는 경우")
    @Test
    void moveTest() {
        int[] randomInt = {4,5,6,7,8,9};
        for (int i : randomInt) {
            assertThat(RunGame.randomMove(i)).isTrue();
        }
    }
}
