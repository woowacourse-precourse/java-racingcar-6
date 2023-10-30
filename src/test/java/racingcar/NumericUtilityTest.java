package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumericUtilityTest {

    @Test
    @DisplayName("숫자가 4 이상이라면 그대로 반환")
    void convertNumberIfGreaterOrEqualToFourTest1() {
        int number1 = 4;
        int number2 = 9;
        int expected1 = 4;
        int expected2 = 9;

        int actual1 = NumericUtility.convertNumberIfGreaterOrEqualToFour(number1);
        int actual2 = NumericUtility.convertNumberIfGreaterOrEqualToFour(number2);

        Assertions.assertThat(actual1).isEqualTo(expected1);
        Assertions.assertThat(actual2).isEqualTo(expected2);
    }

    @Test
    @DisplayName("숫자가 4 미만이라면 0을 반환")
    void convertNumberIfGreaterOrEqualToFourTest2() {
        int number1 = 0;
        int number2 = 3;
        int expected1 = 0;
        int expected2 = 0;

        int actual1 = NumericUtility.convertNumberIfGreaterOrEqualToFour(number1);
        int actual2 = NumericUtility.convertNumberIfGreaterOrEqualToFour(number2);

        Assertions.assertThat(actual1).isEqualTo(expected1);
        Assertions.assertThat(actual2).isEqualTo(expected2);
    }
}