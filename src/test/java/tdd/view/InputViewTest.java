package tdd.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    @Test
    void 입력값이_정해진_값과_맞으면_통과() {
        String input = "car1,car2,car3";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        assertThat(input).isEqualTo("car1,car2,car3");
    }
}
