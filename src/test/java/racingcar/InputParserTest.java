package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.InputParser;

public class InputParserTest {
    InputParser inputParser = new InputParser();

    @Test
    @DisplayName("자동차 이름 입력을 List형태로 파싱하는지를 테스트")
    void parserCarNameTest() {
        String input1 = "car1,car2,car3";
        String input2 = "car1.car2,car3";

        List<String> result1 = inputParser.parseCarName(input1);
        List<String> result2 = inputParser.parseCarName(input2);
        List<String> expected1 = Arrays.asList("car1", "car2", "car3");
        List<String> expected2 = Arrays.asList("car1.car2", "car3");

        assertThat(result1).isEqualTo(expected1);
        assertThat(result2).isEqualTo(expected2);
    }
}
