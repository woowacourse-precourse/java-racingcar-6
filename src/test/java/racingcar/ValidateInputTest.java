package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingcar.input.ValidateInput;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidateInputTest {
        @CsvSource({"123423, 6",
                    "'     ', 5",
                    "abcde, 5",
                    "가나다라, 4",
                    "'',0"})
        @ParameterizedTest
        void 최대_문자개수_여부_검증_성공(String input,int maxStringLength) {
                assertSimpleTest(
                                () -> assertThatCode(() -> ValidateInput.validateStringCount(input, maxStringLength))
                                                .doesNotThrowAnyException());
        }

        @CsvSource({"123423, 1",
                    "'     ', 1",
                    "abcde, 1",
                    "가나다라,3"})
        @ParameterizedTest
        void 최대_문자개수_여부_검증_실패(String input,int maxStringLength) {
                assertSimpleTest(
                                () -> assertThatThrownBy(() -> ValidateInput.validateStringCount(input, maxStringLength))
                                                .isInstanceOf(IllegalArgumentException.class)
                                                .hasMessageContaining("[ERROR]"));
        }

        @CsvSource({"-123",
                    "123",
                    "203949",
                    "555555",
                    "abcdef",
                    "ABCDEF"})
        @ParameterizedTest
        void 정수_검증_성공(String input) {
                assertSimpleTest(
                                () -> assertThatCode(() -> ValidateInput.validateIntegerInput(input))
                                                .doesNotThrowAnyException());
        }

        @CsvSource({"0xfff",
                    "moo",
                    "1.1"})
        @ParameterizedTest
        void 정수_검증_실패(String input) {
                assertSimpleTest(
                                () -> assertThatThrownBy(() -> ValidateInput.validateIntegerInput(input))
                                                .isInstanceOf(IllegalArgumentException.class)
                                                .hasMessageContaining("[ERROR]"));
        }

        @CsvSource({"123",
                    "203949",
                    "555555",
                    "abcdef",
                    "ABCDEF"})
        @ParameterizedTest
        void 자연수_검증_성공(String input) {
                assertSimpleTest(
                                () -> assertThatCode(() -> ValidateInput.validatePositiveNumberInput(input))
                                                .doesNotThrowAnyException());
        }

        @CsvSource({"-123",
                    "-abc",
                    "0xfff",
                    "moo",
                    "1.1",
                    "0",
                    "-abcdef",
                    "-ABCDEF",})
        @ParameterizedTest
        void 자연수_검증_실패(String input) {
                assertSimpleTest(
                                () -> assertThatThrownBy(() -> ValidateInput.validatePositiveNumberInput(input))
                                                .isInstanceOf(IllegalArgumentException.class)
                                                .hasMessageContaining("[ERROR]"));
        }

        @CsvSource({"123",
                    "203949",
                    "555555",})
        @ParameterizedTest
        void 정수_입력값_자연수_검증_성공(Integer input) {
                assertSimpleTest(
                                () -> assertThatCode(() -> ValidateInput.validatePositiveNumberFromInteger(input))
                                                .doesNotThrowAnyException());
        }


        @CsvSource({"-123",
                    "-1000"})
        @ParameterizedTest
        void 정수_입력값_자연수_검증_실패(Integer input) {
                assertSimpleTest(
                                () -> assertThatThrownBy(() -> ValidateInput.validatePositiveNumberFromInteger(input))
                                                .isInstanceOf(IllegalArgumentException.class)
                                                .hasMessageContaining("[ERROR]"));
        }

        
}
