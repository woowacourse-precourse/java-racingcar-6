package racingcar.race;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

public class CarNameExceptionProcessingTest {

    @Test
    public void testCheckEmpty() {
        String validCarName = "Car";
        String invalidCarName = "";

        assertThatCode(() -> CarNameExceptionProcessing.checkEmpty(validCarName))
                .doesNotThrowAnyException();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CarNameExceptionProcessing.checkEmpty(invalidCarName));
    }

    @Test
    public void testCheckEquals() {
        String validCarName = "Car";
        String invalidCarName = " ";

        assertThatCode(() -> CarNameExceptionProcessing.checkEquals(validCarName))
                .doesNotThrowAnyException();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CarNameExceptionProcessing.checkEquals(invalidCarName));
    }
}


