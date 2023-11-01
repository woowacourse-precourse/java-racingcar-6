package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewValidatorTest {
    private InputViewValidator inputViewValidator;

    private static final String STRING_EMPTY_ERROR_MESSAGE = "입력은 빈 값이면 안됩니다.";
    private static final String CAR_NAME_EMPTY_ERROR_MESSAGE = "각각의 차의 이름은 빈 값이면 안됩니다.";
    private static final String INVALID_CAR_NAME_LENGTH_ERROR_MESSAGE = "차의 이름의 길이는 5글자 이하만 가능합니다.";
    private static final String DUPLICATE_CAR_NAME_EXISTS_ERROR_MESSAGE = "차의 이름 중 중복된 이름이 존재해선 안됩니다.";

    private static final String PARSE_INT_FAILURE_ERROR_MESSAGE = "라운드 수는 정수 형식만 가능합니다.";
    private static final String INVALID_INTEGER_RANGE_ERROR_MESSAGE = "라운드 수는 양수만 가능합니다.";

    static Stream<Arguments> invalidCarNamesAndErrorMessages() {
        return Stream.of(
                Arguments.of("", STRING_EMPTY_ERROR_MESSAGE),
                Arguments.of(",car1,car2,car3", CAR_NAME_EMPTY_ERROR_MESSAGE),
                Arguments.of("car1,,car2,car3", CAR_NAME_EMPTY_ERROR_MESSAGE),
                Arguments.of("car1,car2,car3,", CAR_NAME_EMPTY_ERROR_MESSAGE),
                Arguments.of("car123456,car2,car3", INVALID_CAR_NAME_LENGTH_ERROR_MESSAGE),
                Arguments.of("car1,car2,car1", DUPLICATE_CAR_NAME_EXISTS_ERROR_MESSAGE)
        );
    }

    static Stream<Arguments> invalidTotalRoundNumberAndErrorMessages() {
        return Stream.of(
                Arguments.of("", STRING_EMPTY_ERROR_MESSAGE),
                Arguments.of("car1", PARSE_INT_FAILURE_ERROR_MESSAGE),
                Arguments.of("1.0", PARSE_INT_FAILURE_ERROR_MESSAGE),
                Arguments.of("-1", INVALID_INTEGER_RANGE_ERROR_MESSAGE),
                Arguments.of("0", INVALID_INTEGER_RANGE_ERROR_MESSAGE)
        );
    }

    @BeforeEach
    void setUp() {
        inputViewValidator = new InputViewValidator();
    }

    @ParameterizedTest
    @MethodSource("invalidCarNamesAndErrorMessages")
    void 입력받은_차의_이름들이_적절하지_않으면_IllegalArgumentException을_던진다(String string, String errorMessage){
        assertThrows(IllegalArgumentException.class, () -> inputViewValidator.validateCarNames(string), errorMessage);
    }

    @Test
    void 쉼표_뒤에_공백을_입력하여_구분해도_IllegalArgumentException을_던지지_않는다(){
        String string = "car1, car2, car3";
        assertDoesNotThrow(() -> inputViewValidator.validateCarNames(string));
    }

    @ParameterizedTest
    @MethodSource("invalidTotalRoundNumberAndErrorMessages")
    void 입력받은_총_라운드_수가_적절하지_않으면_IllegalArguementException을_던진다(String string, String errorMessage){
        assertThrows(IllegalArgumentException.class, () -> inputViewValidator.validateTotalRoundNumber(string), errorMessage);
    }

    private void injectSystemIn(String userInput){
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
    }

    private String captureSystemOut(Runnable runnable) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        try {
            runnable.run();
            return new String(outputStream.toByteArray(), Charset.defaultCharset());
        } finally {
            System.setOut(originalOut);
        }
    }
}
