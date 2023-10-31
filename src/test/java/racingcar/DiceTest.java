package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

class DiceTest {

    @Test
    void getDice() {
        when(Randoms.pickNumberInRange(0, 9)).thenReturn(5);

        Dice dice = new Dice();

        int result = dice.getDice();

        assertThat(result).isEqualTo(5);
    }
}