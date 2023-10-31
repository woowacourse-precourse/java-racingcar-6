package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputMovingNumberTest {

    @Test
    public void inputMovingNumberTestInput() {
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
