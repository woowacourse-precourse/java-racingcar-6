package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void getWinnerList() {
        List<String> names = Arrays.asList("uk", "eu", "n");
        List<Car> cars = names.stream()
                .map(Model::generateCar)
                .toList();

        assertRandomNumberInRangeTest(
                () -> {
                    for (Car car:cars) {
                        car.moveOrStop();
                    }
                    Rank testRank = Model.generateRank(cars);
                    List<String> testWinner = testRank.getWinnerList();

                    assertEquals(testWinner, List.of("eu"));
                },
                1, 4, 1
        );
    }
}