package racingcar.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatNoException;

class ValidationTest {
    private static final String EXCEPTION_MESSAGE_FOR_WRONG_LENGTH_OF_CAR_NAME =
            "올바르지 않은 자동차 이름입니다. 각 자동차 이름은 5글자 이하여야 합니다.";
    private static final String EXCEPTION_MESSAGE_FOR_NON_NUM =
            "정수가 아닙니다.";
    private static final String EXCEPTION_MESSAGE_FOR_NEGATIVE_NUMBER =
            "양의 정수를 입력하셔야 합니다.";

    @Test
    void testCheckingCarNames_testCasesHaveLengthOver5() {
        String[] testCases = {
                "Ritchie",
                "Dijkstra",
                "Bellman",
                "Kernighan",
                "Kurose",
                "Patterson",
                "Henessy",
                "strang"
        };

        assertThatThrownBy(() -> Validation.checkCarNames(testCases))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_MESSAGE_FOR_WRONG_LENGTH_OF_CAR_NAME);
    }

    @Test
    void testCheckingCarNames_successCases() {
        String[] testCases = {
                "John",
                "messi",
                "a"
        };

        assertThatNoException().isThrownBy(() -> Validation.checkCarNames(testCases));
    }

    @Test
    void testCheckIsDigit_notNumber() {
        String[] testCases = {
                "a122",
                "50d",
                "3!67",
                "abcd",
                "a",
                "@",
                "3.14",
                "-3.14"
        };

        for (String testCase : testCases) {
            assertThatThrownBy(() -> Validation.checkIfInteger(testCase))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(EXCEPTION_MESSAGE_FOR_NON_NUM);
        }
    }

    @Test
    void testCheckIsDigit_success() {
        String[] testCases = {
                "1",
                "0",
                "113",
                "5701",
                "-105",
                "-0"
        };

        for (String testCase : testCases) {
            assertThatNoException().isThrownBy(() -> Validation.checkIfInteger(testCase));
        }
    }

    @Test
    void testCheckIfNonNegative_negativeNumbers() {
        int[] testCases = {
                -13, -25,
                -76, -57
        };

        for (int testCase : testCases) {
            assertThatThrownBy(() -> Validation.checkIfNonNegative(testCase))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(EXCEPTION_MESSAGE_FOR_NEGATIVE_NUMBER);
        }
    }

    @Test
    void testCheckIfNonNegative_nonNegativeNumbers() {
        int[] testCases = {
                0, 1, 13, 5
        };

        for (int testCase : testCases) {
            assertThatNoException().isThrownBy(() -> Validation.checkIfNonNegative(testCase));
        }
    }
}