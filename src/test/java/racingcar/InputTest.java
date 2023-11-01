package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputTest {
    private Input input;

    private static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }

    @BeforeEach
    void given() {
        input = new Input("pobi,woni,jun", 5);
    }

    @Test
    @DisplayName("Car 테스트")
    @ParameterizedTest
    @CsvSource({"pobi,woni,jun", "5"})
    void testGetCars(String cars, String trys) {
        InputStream in = createInputStream(cars, trys);
        System.setIn(in);

        assertEquals("pobi,woni,jun", input.getCars());
        assertEquals(5, input.getTrys());

    }

    private static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
    private InputStream createInputStream(String cars, String trys) {
        List<InputStream> streams = Arrays.asList(
                generateUserInput(cars),
                generateUserInput(trys)
        );

        return new SequenceInputStream(Collections.enumeration(streams));
    }
}