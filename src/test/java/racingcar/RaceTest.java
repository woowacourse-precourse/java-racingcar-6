package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @Test
    void pickNumberInRange_0에서_9까지의_정수_중_한개의_정수_반환(){
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        Boolean inRange = true;
        if(randomNumber >= 1 && randomNumber <= 9){
            inRange = true;
        } else {
            inRange = false;
        }
        assertThat(inRange).isTrue();
    }
}
