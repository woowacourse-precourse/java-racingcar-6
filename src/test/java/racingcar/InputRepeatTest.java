package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import racingcar.controller.CarNames;
import racingcar.controller.RepeatNum;

public class InputRepeatTest {
    @Test
    void setRepeatNum_확인() {
        String ts = "4";
        InputStream in = new ByteArrayInputStream(ts.getBytes());
        System.setIn(in);

        int expected = 4;
        assertThat(RepeatNum.setRepeatNum()).isEqualTo(expected);
    }
    @Test
    void setRepeatNum_확인2() {
        String ts = "2147483647";
        InputStream in = new ByteArrayInputStream(ts.getBytes());
        System.setIn(in);

        int expected = 2147483647;
        assertThat(RepeatNum.setRepeatNum()).isEqualTo(expected);
    }

    @Test
    void setRepeatNum_에러확인() {
        String ts = "aasda";
        InputStream in = new ByteArrayInputStream(ts.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> RepeatNum.setRepeatNum())
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void setRepeatNum_에러확인2() {
        String ts = "-1";
        InputStream in = new ByteArrayInputStream(ts.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> RepeatNum.setRepeatNum())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
