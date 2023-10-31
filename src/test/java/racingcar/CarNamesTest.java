package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class CarNamesTest {

    private CarNames carNames;

    @Test
    void carNamesTestInput() {
        carNames = new CarNames();

        String input = "red,blue";

        InputStream realSystemIn = System.in;
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        List<String> result = carNames.inputCarNames();

        System.setIn(realSystemIn);

        assertThat(result).contains("red", "blue");
    }
}