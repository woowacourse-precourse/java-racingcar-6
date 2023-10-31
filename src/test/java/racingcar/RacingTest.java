package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {

    @Test
    public void 이름에_빈_문자열_기입() {
        String input = "";

        final Racing racing = new Racing();

        assertThatThrownBy(() -> {
            racing.ready();
        })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

}
