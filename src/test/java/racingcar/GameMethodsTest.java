package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Index.atIndex;
import static racingcar.GameMethods.decideWinner;
import static racingcar.GameMethods.goOrStop;
import static racingcar.GameMethods.makeRandNum;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class GameMethodsTest {

    @Test
    void makeRandNumTest() {
        int numberOfCars = 3;
        int[] howFar = makeRandNum(3);

        for (int n : howFar) {
            assertThat(n).isBetween(0, 9);
        }
    }

    @Test
    void goOrStopTest() {
        int numberOfCars = 3;
        String[] movedDistance = {"", "", ""};
        int[] howFar = {1, 5, 9};
        goOrStop(numberOfCars, movedDistance, howFar);

        assertThat(movedDistance)
                .contains("", atIndex(0))
                .contains("-", atIndex(1))
                .contains("-", atIndex(2));
    }

    @Test
    void decideWinnerTest() {
        String[] movedDistance = {"---", "----", "", "----"};
        String[] carNames = {"do", "re", "mi", "fa"};
        ArrayList<String> winningCandidate = decideWinner(movedDistance, carNames);

        assertThat(winningCandidate)
                .contains("re", atIndex(0))
                .contains("fa", atIndex(1))
                .hasSize(2);
    }
}