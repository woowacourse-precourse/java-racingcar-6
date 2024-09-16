package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class InputMovingNumberTest {

    @Test
    void inputMovingNumberTestInput() {
        Moving moving = new Moving();
        String input = "9";

        InputStream realSystemIn = System.in;
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        int result = moving.inputMovingNumber();

        System.setIn(realSystemIn);

        assertThat(result).isEqualTo(9);
    }
}
