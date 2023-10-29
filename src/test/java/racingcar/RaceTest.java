package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {

    @Test
    public void 레이스_생성_테스트() throws Exception {
        Car car1 = new Car("alpha");
        Car car2 = new Car("bravo");
        Car car3 = new Car("char");

        int expectedRound = 3;
        List<Car> expectedCars = Arrays.asList(car1, car2, car3);

        Race race = new Race(3, List.of(car1, car2, car3));

        Assertions.assertThat(race.getRound()).isEqualTo(expectedRound);
        Assertions.assertThat(race.getCars()).isEqualTo(expectedCars);
    }


}