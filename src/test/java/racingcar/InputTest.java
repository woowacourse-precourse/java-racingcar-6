package racingcar;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.Exception.*;
import static racingcar.Input.getCarName;
import static racingcar.Input.getTryNumber;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputTest {

    InputStream generateByteArrayInputStream(String userInput) {
        return new ByteArrayInputStream(userInput.getBytes());
    }

    @BeforeEach
    void closeScanner() {
        Console.close();
    }

    @AfterEach
    void restoreSystemIn() {
        System.setIn(System.in);
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car3"})
    void getCarNameGeneralTest(String userInput) {
        String[] answer = {"car1", "car2", "car3"};
        InputStream userInputStream = generateByteArrayInputStream(userInput);
        System.setIn(userInputStream);
        assertArrayEquals(answer,getCarName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,overFiveCharacters"})
    void getCarNameLengthExceptionTest(String userInput) {
        InputStream userInputStream = generateByteArrayInputStream(userInput);
        System.setIn(userInputStream);
        try {
            getCarName();
        } catch (IllegalArgumentException illegalArgumentException) {
            assertEquals(INVALID_CAR_NAME_LENGTH_MESSAGE, illegalArgumentException.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void getCarNameEmptyExceptionTest(String userInput) {
        InputStream userInputStream = generateByteArrayInputStream(userInput);
        System.setIn(userInputStream);
        try {
            getCarName();
        } catch (IllegalArgumentException illegalArgumentException) {
            assertEquals(INVALID_CAR_NUMBER_MESSAGE, illegalArgumentException.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"42"})
    void getTryNumberGeneralTest(String userInput) {
        int answer = 42;
        InputStream userInputStream = generateByteArrayInputStream(userInput);
        System.setIn(userInputStream);
        assertEquals(answer,getTryNumber());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1!23"})
    void getTryNumberNumericExceptionTest(String userInput) {
        InputStream userInputStream = generateByteArrayInputStream(userInput);
        System.setIn(userInputStream);
        try {
            getCarName();
        } catch (IllegalArgumentException illegalArgumentException) {
            assertEquals(INVALID_TRY_NUMBER_CHARACTER_MESSAGE, illegalArgumentException.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"99999999999999"})
    void getTryNumberRangeExceptionTest(String userInput) {
        InputStream userInputStream = generateByteArrayInputStream(userInput);
        System.setIn(userInputStream);
        try {
            getCarName();
        } catch (IllegalArgumentException illegalArgumentException) {
            assertEquals(INVALID_TRY_NUMBER_RANGE_MESSAGE, illegalArgumentException.getMessage());
        }
    }
}
