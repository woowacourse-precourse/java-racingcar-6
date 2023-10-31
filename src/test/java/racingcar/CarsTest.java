package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.util.InputParser;

public class CarsTest {
    String playerInput = "pobi,woni,kibum";
    InputParser inputParser = new InputParser();

    Cars cars = new Cars(inputParser.parseCarName(playerInput));

    @Test
    @DisplayName("자동차의 각 이름을 리턴하는 기능테스트")
    void testGetNames() {
        List<String> names = cars.getNames();
        List<String> expected = Arrays.asList("pobi", "woni", "kibum");

        assertThat(names).containsAll(expected);
    }

    @Test
    @DisplayName("Car를 각각 Drive시키고 매 실행 결과를 알아내는 기능 테스트 ")
    void testDriveAllAndGetDistances() {
        cars.driveAll();
        List<Integer> result = cars.getTotalDistances();

        for (int number : result) {
            assertThat(number == 0 || number == 1).isTrue();
        }
    }

    @Test
    @DisplayName("우승자를 리턴하는 기능")
    void testGetWinners() {
        for (int i = 0; i < 5; i++) {
            cars.driveAll();
        }
        List<String> winners = cars.getWinners();
        List<Integer> result = cars.getTotalDistances();
        List<String> names = cars.getNames();
        int maxDistance = Collections.max(result);
        List<String> expected = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) == maxDistance) {
                expected.add(names.get(i));
            }
        }
        assertThat(expected).containsAll(winners);
    }

}
