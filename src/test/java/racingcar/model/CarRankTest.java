package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class CarRankTest {

    @Test
    void getWinnerList() {
        List<String> names = Arrays.asList("uk", "eu", "n");
        AtomicInteger index = new AtomicInteger();
        List<Car> cars = names.stream()
                .map(name -> (Car) Model.generateCar(name, index.getAndIncrement()))
                .toList();

        assertRandomNumberInRangeTest(
                () -> {
                    for (Car car:cars) {
                        car.moveOrStop();
                    }
                    CarRank testCarRank = (CarRank) Model.generateRank(cars);
                    List<String> testWinner = testCarRank.getWinnerList();

                    assertEquals(testWinner, List.of("eu"));
                },
                1, 4, 1
        );
    }
}