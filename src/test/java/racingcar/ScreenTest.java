package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ScreenTest {

    @Test
    void 자동차_이름_입력() {
        String input = "pobi,yen,joy,red";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String[] result = Screen.inputCarNames();

        assertThat(result).hasSize(4);
        assertThat(result).containsExactly("pobi", "yen", "joy", "red");
    }
}
