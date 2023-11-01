package racingcar;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

public class ControllerTest {
    private Controller controller;

    @BeforeEach
    void setUp() {
        controller = new Controller();
    }

    @Test
    void 문자열_분할_case_1() {
        String carNames = "car1,car2,car3";

        ArrayList<String> expected = new ArrayList<>(Arrays.asList("car1", "car2", "car3"));
        ArrayList<String> result = controller.splitCarNames(carNames);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 문자열_분할_case_2() {
        String carNames = "car1,car2,,";

        ArrayList<String> expected = new ArrayList<>(Arrays.asList("car1", "car2", "", ""));
        ArrayList<String> result = controller.splitCarNames(carNames);

        assertThat(result).isEqualTo(expected);
    }
}
