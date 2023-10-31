package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import racingcar.controller.RepeatController;
import racingcar.controller.RepeatNumCreator;

public class InputRepeatTest {
    RepeatNumCreator repeatNumCreator = new RepeatController();

    @Test
    void setRepeatNum_확인() {
        int repeatNum = repeatNumCreator.createRepeatNum("4");

        int expected = 4;
        assertThat(repeatNum).isEqualTo(expected);
    }
    @Test
    void setRepeatNum_에러() {
        assertThatThrownBy(() -> repeatNumCreator.createRepeatNum("abc"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> repeatNumCreator.createRepeatNum("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> repeatNumCreator.createRepeatNum("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
