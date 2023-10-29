package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {

    public static final int MOVING_FORWARD = 4;
    public static final int STOP = 3;

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

    @Nested
    class proceedRound_메서드는 {
        @Test
        public void 전진일_때_모두_전진() throws Exception {
            Car car1 = new Car("alpha");
            Car car2 = new Car("bravo");
            Car car3 = new Car("char");

            int expectedRound = 3;
            List<Car> expectedCars = Arrays.asList(car1, car2, car3);

            Race race = new Race(3, List.of(car1, car2, car3));

            camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        for (int i = 0; i < expectedRound; i++) {
                            race.proceedRound();
                        }
                        Assertions.assertThat(race.getCars().get(0).getDistance()).isEqualTo(expectedRound);
                        Assertions.assertThat(race.getCars().get(1).getDistance()).isEqualTo(expectedRound);
                        Assertions.assertThat(race.getCars().get(2).getDistance()).isEqualTo(expectedRound);
                    },
                    MOVING_FORWARD,
                    MOVING_FORWARD
            );
        }

        @Test
        public void 정지일때_모두_정지() throws Exception {
            Car car1 = new Car("alpha");
            Car car2 = new Car("bravo");
            Car car3 = new Car("char");

            int expectedRound = 3;
            List<Car> expectedCars = Arrays.asList(car1, car2, car3);

            Race race = new Race(3, List.of(car1, car2, car3));

            camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        for (int i = 0; i < expectedRound; i++) {
                            race.proceedRound();
                        }
                        Assertions.assertThat(race.getCars().get(0).getDistance()).isEqualTo(0);
                        Assertions.assertThat(race.getCars().get(1).getDistance()).isEqualTo(0);
                        Assertions.assertThat(race.getCars().get(2).getDistance()).isEqualTo(0);
                    },
                    STOP,
                    STOP
            );
        }
    }

}