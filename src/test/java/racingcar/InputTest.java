package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {

    private Input input;

    private static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }
    @BeforeEach
    void given() {
        input = new Input("I love pobi", 3);
    }

    @Test
    @DisplayName("Car 테스트")
    void testCar() {
        InputStream pobi = setReadLine("I love pobi\3");
        System.setIn(pobi);

        String actualCars = input.getCars();
        String expectCars = "I love pobi";

        int actualTrys = input.getTrys();
        int expectTrys = 3;

        assertEquals(expectCars, actualCars);
        assertEquals(expectTrys, actualTrys);
    }


}