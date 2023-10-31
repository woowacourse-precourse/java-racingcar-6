package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.model.Name;
import racingcar.util.Constants;

public class NameTest {

    @Test
    void 이름객체의_예외_처리() {
        assertThatThrownBy(() -> new Name("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constants.EXCEED_NAME_SIZE.constant);
    }

}
