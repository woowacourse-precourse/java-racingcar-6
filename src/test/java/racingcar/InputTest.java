package racingcar;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static racingcar.Input.getCarName;

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
}
