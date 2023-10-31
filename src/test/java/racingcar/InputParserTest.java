package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.util.InputParser;

public class InputParserTest {
    InputParser inputParser = new InputParser();

    private List<String> getNames(List<Car> cars) {
        List<String> names = new ArrayList<>();
        for (Car car : cars) {
            names.add(car.toString());
        }
        return names;
    }

    @Test
    @DisplayName("자동차 이름 입력을 List형태로 파싱하는지를 테스트")
    void parserCarNameTest() {
        String input1 = "car1,car2,car3";
        String input2 = "q.w,car3";

        List<String> result1 = getNames(inputParser.parseCarName(input1));
        List<String> result2 = getNames(inputParser.parseCarName(input2));
        List<String> expected1 = Arrays.asList("car1", "car2", "car3");
        List<String> expected2 = Arrays.asList("q.w", "car3");
        assertThat(result1).containsAll(expected1);
        assertThat(result2).containsAll(expected2);
    }

    @Test
    @DisplayName("시도 횟수 입력을 Int형태로 파싱하는 기능 테스트")
    void parseNumberOfAttemptTest() {
        String input1 = "5";
        String input2 = "425";

        int result1 = inputParser.parseNumberOfAttempt(input1);
        int result2 = inputParser.parseNumberOfAttempt(input2);

        assertThat(result1).isEqualTo(5);
        assertThat(result2).isEqualTo(425);
    }
}
