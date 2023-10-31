package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.utils.Validator.CAR_NAME_BLANK_ERROR_MESSAGE;
import static racingcar.utils.Validator.WRONG_LENGTH_CAR_NAME_ERROR_MESSAGE;

class ControllerTest {

    Controller controller = new Controller();

    private static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private static InputStream getSequenceInputStream(String carNameInput, String attemptCountInput) {
        List<InputStream> streams = Arrays.asList(generateUserInput(carNameInput), generateUserInput(attemptCountInput));
        return new SequenceInputStream(Collections.enumeration(streams));
    }

    private static Stream<Arguments> provideWrongLengthCarNameInput() {
        return Stream.of(
                Arguments.of("Tom,Jinnnn,Ive\n", "3\n"),
                Arguments.of("Tommmm,Jin,Ive\n", "5\n")
        );
    }

    @ParameterizedTest
    @MethodSource("provideWrongLengthCarNameInput")
    void 이름_길이_예외_발생_및_몌시지_확인(String carNameInput, String AttemptCountInput) {

        System.setIn(getSequenceInputStream(carNameInput, AttemptCountInput));
        try {
            controller.run();
        } catch (IllegalArgumentException e) {
            assertEquals(WRONG_LENGTH_CAR_NAME_ERROR_MESSAGE, e.getMessage());
        }
        Console.close();
    }

    private static Stream<Arguments> provideEmptyCarNameInput() {
        return Stream.of(
                Arguments.of("Tom, ,Ive\n", "3\n"),
                Arguments.of(" ,Jin,Ive\n", "5\n")
        );
    }

    @ParameterizedTest
    @MethodSource("provideEmptyCarNameInput")
    void 빈_이름_예외_발생_및_몌시지_확인(String carNameInput, String AttemptCountInput) {

        System.setIn(getSequenceInputStream(carNameInput, AttemptCountInput));
        try {
            controller.run();
        } catch (IllegalArgumentException e) {
            assertEquals(CAR_NAME_BLANK_ERROR_MESSAGE, e.getMessage());
        }
        Console.close();
    }
}