package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @Test
    public void getInputCarName() {
        // given
        String expect = "car,name";
        systemIn(expect);

        // when
        String input = InputView.getInputCarName();

        // then
        assertThat(input).isEqualTo(expect);
    }

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}