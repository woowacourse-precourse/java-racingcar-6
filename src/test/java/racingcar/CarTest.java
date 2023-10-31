package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void moveTest() {
        int position = 0;
        int randomNumber = Randoms.pickNumberInRange(4, 9);
        if (randomNumber >= 4) {
            position++;
        }
        assertThat(position).isEqualTo(1);
    }

    @Test
    void stopTest() {
        int position = 0;
        int randomNumber = Randoms.pickNumberInRange(0, 3);
        if (randomNumber >= 4) {
            position++;
        }
        assertThat(position).isEqualTo(0);
    }
}