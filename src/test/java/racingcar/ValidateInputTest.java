package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingcar.input.ValidateInput;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.endsWith;

class ValidateInputTest {
        @CsvSource({ "123423, 6",
                        "'     ', 5",
                        "abcde, 5",
                        "가나다라, 4",
                        "'',0" })
        @ParameterizedTest
        void 최대_문자개수_여부_검증_성공(String input, int maxStringLength) {
                assertSimpleTest(
                                () -> assertThatCode(() -> ValidateInput.validateStringCount(input, maxStringLength))
                                                .doesNotThrowAnyException());
        }

        @CsvSource({ "123423, 1",
                        "'     ', 1",
                        "abcde, 1",
                        "가나다라,3" })
        @ParameterizedTest
        void 최대_문자개수_여부_검증_실패(String input, int maxStringLength) {
                assertSimpleTest(
                                () -> assertThatThrownBy(
                                                () -> ValidateInput.validateStringCount(input, maxStringLength))
                                                .isInstanceOf(IllegalArgumentException.class)
                                                .hasMessageContaining("[ERROR]"));
        }

        @CsvSource({ "-123",
                        "123",
                        "203949",
                        "555555",
                        "abcdef",
                        "ABCDEF" })
        @ParameterizedTest
        void 정수_검증_성공(String input) {
                assertSimpleTest(
                                () -> assertThatCode(() -> ValidateInput.validateIntegerInput(input))
                                                .doesNotThrowAnyException());
        }

        @CsvSource({ "0xfff",
                        "moo",
                        "1.1" })
        @ParameterizedTest
        void 정수_검증_실패(String input) {
                assertSimpleTest(
                                () -> assertThatThrownBy(() -> ValidateInput.validateIntegerInput(input))
                                                .isInstanceOf(IllegalArgumentException.class)
                                                .hasMessageContaining("[ERROR]"));
        }

        @CsvSource({ "123",
                        "203949",
                        "555555",
                        "abcdef",
                        "ABCDEF",
                        "0" })
        @ParameterizedTest
        void 양수_및_0_검증_성공(String input) {
                assertSimpleTest(
                                () -> assertThatCode(() -> ValidateInput.validatePositiveNumberInput(input))
                                                .doesNotThrowAnyException());
        }

        @CsvSource({ "-123",
                        "-abc",
                        "0xfff",
                        "moo",
                        "1.1",
                        "-abcdef",
                        "-ABCDEF" })
        @ParameterizedTest
        void 양수_및_0_검증_실패(String input) {
                assertSimpleTest(
                                () -> assertThatThrownBy(() -> ValidateInput.validatePositiveNumberInput(input))
                                                .isInstanceOf(IllegalArgumentException.class)
                                                .hasMessageContaining("[ERROR]"));
        }

        @CsvSource({ "123",
                        "203949",
                        "555555",
                        "0" })
        @ParameterizedTest
        void 정수_입력값_양수_및_0_검증_성공(Integer input) {
                assertSimpleTest(
                                () -> assertThatCode(() -> ValidateInput.validatePositiveNumberFromInteger(input))
                                                .doesNotThrowAnyException());
        }

        @CsvSource({ "-123",
                        "-1000" })
        @ParameterizedTest
        void 정수_입력값_양수_및_0_검증_실패(Integer input) {
                assertSimpleTest(
                                () -> assertThatThrownBy(() -> ValidateInput.validatePositiveNumberFromInteger(input))
                                                .isInstanceOf(IllegalArgumentException.class)
                                                .hasMessageContaining("[ERROR]"));
        }

        @CsvSource({ "0, 1",
                        "-10, 30",
                        " 5, 1000" })
        @ParameterizedTest
        void 숫자_범위_검증_성공(Integer start, Integer end) {
                assertSimpleTest(
                                () -> assertThatCode(() -> ValidateInput.validateIntegerRange(start, end))
                                                .doesNotThrowAnyException());
        }


        @CsvSource({ "1, 0",
                        "30, -10",
                        "1000, 5" })
        @ParameterizedTest
        void 숫자_범위_검증_실패(Integer start, Integer end) {
                assertSimpleTest(
                                () -> assertThatThrownBy(() -> ValidateInput.validateIntegerRange(start, end))
                                                .isInstanceOf(IllegalArgumentException.class)
                                                .hasMessageContaining("[ERROR]"));
        }

}
