package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayTest {

    RacingCar test = new RacingCar();

    @Test
    public void testGetRandomValue(){

        for(int i=0;i<30;i++){
            int result = test.getRandomValue();
            assertThat(result).isLessThanOrEqualTo(9);
        }
    }

    @Test
    public void testJudgeMoveOrStop(){

        test.playersMap.put("go", "");
        test.playersMap.put("stop", "");

        test.judgeMoveOrStop("go", 4);
        test.judgeMoveOrStop("stop", 3);

        assertThat(test.playersMap.get("go")).isEqualTo("-");
        assertThat(test.playersMap.get("stop")).isEqualTo("");
    }
}
