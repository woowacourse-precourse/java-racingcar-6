package racingcar.unit.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    @Test
    void 입력값이_정해진_값과_맞으면_통과() {
        String input = "car1,car2,car3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThat(Console.readLine()).isEqualTo("car1,car2,car3");
    }

    @Test
    void 입력값이_정해진_값과_틀리면_통과() {
        String input = "car1,car2,car3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThat(Console.readLine()).isNotEqualTo("car1,car2");
    }
}
