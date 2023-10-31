package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RaceOfficialTest {
    private final RaceOfficial raceOfficial = new RaceOfficial();

    private static final List<Car> cars = new ArrayList<>();
    private static final int CAR_SIZE = 3;

    private static List<Car> winners = new ArrayList<>();
    private static int longestDistance = 2;

    @BeforeAll
    static void carSetUp() {
        for (int i = 0; i < CAR_SIZE; i++) {
            cars.add(new Car(String.format("%d번째", i + 1)));
        }

        Car firstCar = cars.get(0);
        firstCar.moveFowrard();
        firstCar.moveFowrard();

        Car secondCar = cars.get(1);
        secondCar.moveFowrard();
        secondCar.moveFowrard();

        winners.add(firstCar);
        winners.add(secondCar);
    }

    @Test
    void findLongestDistance_최대_거리_찾기() {
        assertThat(raceOfficial.findLongestDistance(cars)).isEqualTo(longestDistance);
    }

    @Test
    void findWinners_우승자_찾기() {
        assertThat(raceOfficial.findWinners(cars)).isEqualTo(winners);
    }
}
