package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberUtilTest {

    @Test
    void isIntegerTakesNonNumberStringAsArgument() {
        String[] testCases = {
                "afis",
                "",
                "1r3",
                "!#$",
                "5^",
                "13f"
        };

        for (String testCase : testCases) {
            Assertions.assertThat(NumberUtil.isInteger(testCase)).isFalse();
        }
    }

    @Test
    void isIntegerTakesNonIntegerStringAsArgument() {
        String[] testCases = {
                "3.14",
                "5.61",
                "14.5",
        };

        for (String testCase : testCases) {
            Assertions.assertThat(NumberUtil.isInteger(testCase)).isFalse();
        }
    }

    @Test
    void isIntegerReturnsTrue() {
        String[] testCases = {
                "13",
                "0",
                "1",
                "60515",
                "-134",
                "-52"
        };

        for (String testCase : testCases) {
            Assertions.assertThat(NumberUtil.isInteger(testCase)).isTrue();
        }
    }
}
