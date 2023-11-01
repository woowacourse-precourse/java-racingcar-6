package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RoundsInputTest {

    RacingCar test = new RacingCar();

    @Test
    void testCheckRoundsInput(){

        String trueValue = "10";
        String falseValue = "aa";

        assertThatCode(() -> test.checkRoundsInput(trueValue))
                .doesNotThrowAnyException();
        assertThatThrownBy(()->test.checkRoundsInput(falseValue))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
