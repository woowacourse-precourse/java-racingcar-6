package racingcar.util;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {

    @Test
    void isSameOrBiggerThanFour_GreaterOrEqual_Four() {
        // Arrange
        int number = 4;

        // Act
        boolean result = Util.isSameOrBiggerThanFour(number);

        // Assert
        assertThat(result).isTrue();
    }

    @Test
    void isSameOrBiggerThanFour_LessThanFour() {
        // Arrange
        int number = 3;

        // Act
        boolean result = Util.isSameOrBiggerThanFour(number);

        // Assert
        assertThat(result).isFalse();
    }
}