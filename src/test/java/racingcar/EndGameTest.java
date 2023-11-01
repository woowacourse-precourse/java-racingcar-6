package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class EndGameTest {

    RacingCar test = new RacingCar();

    @Test
    public void testGetMaxValue(){

        test.playersMap.put("aa", "----");
        test.playersMap.put("bb", "---");
        test.playersMap.put("cc", "-------");
        test.playersMap.put("dd", "--");

        int result = test.getMaxValue();

        assertThat(result).isEqualTo(7);
    }
}
