package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {
    private static final String nameInput = "harry,ron";
    private static final String roundsInput = "8";
    private static InputStream in;
    @Test
    void inputCarNames_차_이름_입력() {
        in = new ByteArrayInputStream(nameInput.getBytes());
        System.setIn(in);

        assertThat(Input.inputCarNames()).isEqualTo(nameInput);
    }

    @Test
    void inputRounds_라운드_수_입력() throws IOException {
        in.read(roundsInput.getBytes());
        System.setIn(in);

        assertThat(Input.inputRounds()).isEqualTo(roundsInput);
    }
}
