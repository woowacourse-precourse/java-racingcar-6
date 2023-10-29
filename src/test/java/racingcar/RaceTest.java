package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Race;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceTest {

    @Test
    void 자동차_이름이_정상적으로_입력되지_않은_경우() {
        String nameIsNull = null;
        String nameIsEmpty = "";
        String nameIsBlank = " ";
        String nameIsLong = "looooong";

        assertThatThrownBy(() -> new Race(nameIsNull, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Race(nameIsEmpty, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Race(nameIsBlank, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Race(nameIsLong, 1)).isInstanceOf(IllegalArgumentException.class);
    }
}
