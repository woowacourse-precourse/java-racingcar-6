package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatCode;

public class RacingTest {
    @Test
    void 레이싱_게임이_정상적으로_수행되는지_확인() {
        //given
        Racing racing = new Racing();
        InputStream input = System.in;

        ByteArrayInputStream in = new ByteArrayInputStream("carA,carB,carC\r3".getBytes());
        System.setIn(in);

        assertThatCode(racing::start).doesNotThrowAnyException();
    }
}
