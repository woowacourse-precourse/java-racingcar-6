package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.util.InputParser;

public class InputParserTest {
    InputParser inputParser = new InputParser();

    private boolean deepEquals(List<Car> cars1, List<Car> cars2) {
        List<String> carNames1 = new ArrayList<>();
        List<String> carNames2 = new ArrayList<>();

        for (Car car : cars1) {
            carNames1.add(car.toString());
        }
        for (Car car : cars2) {
            carNames2.add(car.toString());
        }

        if (carNames1.size() != carNames2.size()) {
            return false;
        }
        for (int i = 0; i < carNames1.size(); i++) {
            if (carNames1.get(i).equals(carNames2)) {
                return false;
            }
        }
        return true;
    }

    @Test
    @DisplayName("자동차 이름 입력을 List형태로 파싱하는지를 테스트")
    void parserCarNameTest() {
        String input1 = "car1,car2,car3";
        String input2 = "q.w,car3";

        List<Car> result1 = inputParser.parseCarName(input1);
        List<Car> result2 = inputParser.parseCarName(input2);
        List<Car> expected1 = new ArrayList<>();
        expected1.add(new Car("car1"));
        expected1.add(new Car("car2"));
        expected1.add(new Car("car3"));
        List<Car> expected2 = new ArrayList<>();
        expected2.add(new Car("q.w"));
        expected2.add(new Car("car3"));

        assertThat(deepEquals(result1, expected1)).isTrue();
        assertThat(deepEquals(result2, expected2)).isTrue();
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
