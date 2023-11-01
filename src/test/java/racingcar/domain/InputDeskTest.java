package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;


import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class InputDeskTest {

    private InputDesk inputdesk;

    @BeforeEach
    void setUp() {
        inputdesk = new InputDesk();

    }

    @Test
    void checkIsNull_입력된_값_null() {
        String input = "";
        assertThatThrownBy(() -> inputdesk.checkIsNull(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사용자 입력값 null");
    }

    @Test
    void checkIsInt_입력된_값_int_아닐때() {
        String input = "inputString";
        assertThatThrownBy(() -> inputdesk.checkIsInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사용자 입력값 Int형 아님");
    }


    @ParameterizedTest
    @CsvSource({"\0,자동차 이름 길이 0", "abcdef,자동차 이름 길이 5 초과"})
    void checkIllegalArgumentException_파싱된_경주_자동차_이름_길이(String input, String expected) {
        assertThatThrownBy(() -> inputdesk.checkIllegalArgumentException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }


    @Test
    void checkIllegalArgumentException_시도할_회수_입력_0이하() {
        int input = (int) (Math.random() * 100 * -1);
        assertThatThrownBy(() -> inputdesk.checkIllegalArgumentException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 회수 입력값 0 이하");
    }

    @Test
    void validateInputCount_입력_문자열_변환_테스트_성공() {
        int result = inputdesk.validateInputCount("5");
        assertThat(result).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource({"null", "abcdef", "-2"})
    void validateInputCount_입력_문자열_변환_테스트_실패(String input) {
        final int ERR_NUM = Integer.MIN_VALUE;
        int result = inputdesk.validateInputCount(input);
        assertThat(result).isEqualTo(ERR_NUM);
    }

    @ParameterizedTest
    @MethodSource("inputCarsSuccessParamsProvider")
    void InputCars_입력_문자열_경주_자동차이름_변환_테스트(String inputStr, List expected) {
        try {
            commandLine(inputStr);
            List result = inputdesk.inputCars();
            assertThat(result).isEqualTo(expected);
        } finally {
            Console.close();
        }
    }

    @ParameterizedTest
    @MethodSource("inputCarsExeptParamsProvider")
    void InputCars_입력_문자열_경주_자동차이름_변환_실패_테스트(String inputStr, String expected) {
        try {
            commandLine(inputStr);
            assertThatThrownBy(() -> inputdesk.inputCars())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(expected);
        } finally {
            Console.close();
        }
    }

    private static Stream<Arguments> inputCarsExeptParamsProvider() {
        return Stream.of(
                arguments("pobi,,jun", "자동차 이름 길이 0"),
                arguments("\0", "자동차 이름 길이 0"),
                arguments("pobi,woni,jununie", "자동차 이름 길이 5 초과")
        );
    }

    private static Stream<Arguments> inputCarsSuccessParamsProvider() {
        return Stream.of(
                arguments("pobi,woni,jun", Arrays.asList("pobi", "woni", "jun"))
        );
    }

    private void commandLine(String inputStr) {
        final byte[] buf = String.join("\n", inputStr).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}