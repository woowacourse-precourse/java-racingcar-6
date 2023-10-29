package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static racingcar.Exception.INVALID_CAR_NAME_LENGTH_MESSAGE;
import static racingcar.Exception.INVALID_CAR_NUMBER_MESSAGE;
import static racingcar.Input.getCarName;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputTest {

    InputStream generateByteArrayInputStream(String userInput) {
        return new ByteArrayInputStream(userInput.getBytes());
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
            Assertions.assertEquals(INVALID_CAR_NAME_LENGTH_MESSAGE, illegalArgumentException.getMessage());
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
            Assertions.assertEquals(INVALID_CAR_NUMBER_MESSAGE, illegalArgumentException.getMessage());
        }
    }
}
