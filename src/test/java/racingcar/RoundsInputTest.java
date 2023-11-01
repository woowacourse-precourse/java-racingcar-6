package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RoundsInputTest {

    RacingCar test = new RacingCar();

    @Test
    void testCheckRoundsInput(){

        String trueValue = "10";
        String charValue = "aa";
        String pointValue = "6.0";
        String minusValue = "-10";
        String zeroValue = "0";

        assertThatCode(() -> test.checkRoundsInput(trueValue))
                .doesNotThrowAnyException();
        assertThatThrownBy(()->test.checkRoundsInput(charValue))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->test.checkRoundsInput(pointValue))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->test.checkRoundsInput(minusValue))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->test.checkRoundsInput(zeroValue))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
