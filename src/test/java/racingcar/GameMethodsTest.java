package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.GameMethods.makeRandNum;

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
}