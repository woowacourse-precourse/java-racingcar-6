package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class RaceServiceTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final int THREE_TIMES = 3;
    private RaceService raceService = new RaceService();

    @Nested
    class 우승자_구하기 {
        @Test
        void 우승자_구하기_한명인_경우() {
            List<Car> cars = List.of(
                    new Car("pobi"),
                    new Car("woni"),
                    new Car("java")
            );

            assertRandomNumberInRangeTest(
                    () -> {
                        raceService.runRaceWithIteration(cars, THREE_TIMES);
                        List<Car> winners = raceService.getWinner(cars);
                        assertThat(winners.size()).isEqualTo(1);
                        assertThat(winners.get(0).getName()).isEqualTo("pobi");
                    },
                    MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD,
                    STOP, MOVING_FORWARD
            );
        }

        @Test
        void 우승자_구하기_두명인_경우() {
            List<Car> cars = List.of(
                    new Car("pobi"),
                    new Car("woni"),
                    new Car("java")
            );
            List<Car> predictedWinners = List.of(cars.get(0), cars.get(2));

            assertRandomNumberInRangeTest(
                    () -> {
                        raceService.runRaceWithIteration(cars, THREE_TIMES);
                        List<Car> winners = raceService.getWinner(cars);
                        assertThat(winners.size()).isEqualTo(2);
                        assertThat(winners.containsAll(predictedWinners)).isTrue();
                    },
                    MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD,
                    MOVING_FORWARD, STOP, MOVING_FORWARD
            );
        }
    }

    @Test
    void 랜덤_번호_가져오기() {
        assertRandomNumberInRangeTest(
                () -> {
                    int movingNumber = Randoms.pickNumberInRange(0, 9);
                    int stopNumber = Randoms.pickNumberInRange(0, 9);
                    assertThat(movingNumber).isEqualTo(4);
                    assertThat(stopNumber).isEqualTo(3);
                },
                MOVING_FORWARD, STOP
        );
    }

    @Nested
    class 자동차_레이스 {
        @Test
        void 자동차_레이스_한번() {
            List<Car> cars = List.of(
                    new Car("pobi"),
                    new Car("woni"),
                    new Car("java")
            );

            assertRandomNumberInRangeTest(
                    () -> {
                        raceService.runRace(cars);
                        Car pobi = cars.get(0);
                        Car woni = cars.get(1);
                        Car java = cars.get(2);
                        assertThat(pobi.getLocation()).isEqualTo(1);
                        assertThat(woni.getLocation()).isEqualTo(1);
                        assertThat(java.getLocation()).isEqualTo(0);
                    },
                    MOVING_FORWARD, MOVING_FORWARD, STOP
            );
        }

        @Test
        void 자동차_레이스_세번() {
            List<Car> cars = List.of(
                    new Car("pobi"),
                    new Car("woni"),
                    new Car("java")
            );

            assertRandomNumberInRangeTest(
                    () -> {
                        raceService.runRaceWithIteration(cars, THREE_TIMES);
                        Car pobi = cars.get(0);
                        Car woni = cars.get(1);
                        Car java = cars.get(2);
                        assertThat(pobi.getLocation()).isEqualTo(3);
                        assertThat(woni.getLocation()).isEqualTo(1);
                        assertThat(java.getLocation()).isEqualTo(2);
                    },
                    MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD,
                    STOP, MOVING_FORWARD
            );
        }
    }
}
