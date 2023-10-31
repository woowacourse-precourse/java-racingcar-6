package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumericUtilityTest {

    @Test
    @DisplayName("숫자가 4 이상이라면 true로 반환")
    void convertNumberIfGreaterOrEqualToFourTest1() {
        int number1 = 4;
        int number2 = 9;
        boolean actual1 = NumericUtility.isNumberGreaterOrEqualToFour(number1);
        boolean actual2 = NumericUtility.isNumberGreaterOrEqualToFour(number2);

        Assertions.assertThat(actual1).isEqualTo(true);
        Assertions.assertThat(actual2).isEqualTo(true);
    }

    @Test
    @DisplayName("숫자가 4 미만이라면 false으로 반환")
    void convertNumberIfGreaterOrEqualToFourTest2() {
        int number1 = 0;
        int number2 = 3;
        boolean actual1 = NumericUtility.isNumberGreaterOrEqualToFour(number1);
        boolean actual2 = NumericUtility.isNumberGreaterOrEqualToFour(number2);

        Assertions.assertThat(actual1).isEqualTo(false);
        Assertions.assertThat(actual2).isEqualTo(false);
    }
}