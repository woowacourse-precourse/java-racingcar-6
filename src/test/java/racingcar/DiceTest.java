package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiceTest {

    Dice dice = new Dice();

    @Test
    void 돌려라() {
        int result = dice.getDice();

        assertThat(result).isBetween(0, 9);
    }
}
