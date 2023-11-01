package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

class InputTest {

    private static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }

    @Test
    @DisplayName("Car 테스트")
    @ValueSource(strings = {"I love pobi", "3"})
    void testCar(String input) {

        InputStream inputStream = setReadLine(input);
        System.setIn(inputStream);

        String expectCars = "I love pobi";
        int expectTrys = 3;

        Input userInput = new Input("I love pobi", 3);

        assertEquals(expectCars, userInput.getCars());
        assertEquals(expectTrys, userInput.getTrys());
    }

}