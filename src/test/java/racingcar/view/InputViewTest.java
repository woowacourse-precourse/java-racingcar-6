package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

class InputViewTest {
    @Test
    public void testCarInput() {
        System.setIn(new ByteArrayInputStream("Car1,Car2,Car3\n".getBytes()));
        String input = InputView.carInput();
        Assertions.assertThat(input).isEqualTo("Car1,Car2,Car3");
    }

    @Test
    public void testRoundInput() {
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        String input = InputView.roundInput();
        Assertions.assertThat(input).isEqualTo("5");
    }
}