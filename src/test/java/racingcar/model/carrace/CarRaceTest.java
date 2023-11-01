package racingcar.model.carrace;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarRace;

public class CarRaceTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final int THREE_TIMES = 3;
    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;
    private static final int ONE_TIMES = 1;
    public static final int MINUS_VALUE = -3;

    @Test
    public void 실행횟수_입력값_숫자형식예외_음수() {
        List<Car> cars = List.of(
                new Car("pobi"),
                new Car("woni"),
                new Car("java")
        );
        int iteration = MINUS_VALUE;

        Assertions.assertThatThrownBy(() -> new CarRace(cars, iteration))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    class 우승자_구하기 {
        @Test
        void 우승자_구하기_한명인_경우() {
            List<Car> cars = List.of(
                    new Car("pobi"),
                    new Car("woni"),
                    new Car("java")
            );
            CarRace carRace = new CarRace(cars, THREE_TIMES);

            assertRandomNumberInRangeTest(
                    () -> {
                        IntStream.range(0, THREE_TIMES).forEach(i -> carRace.runRace());
                        List<Car> winners = carRace.getWinner();
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
            CarRace carRace = new CarRace(cars, THREE_TIMES);
            List<Car> predictedWinners = List.of(cars.get(0), cars.get(2));

            assertRandomNumberInRangeTest(
                    () -> {
                        IntStream.range(0, THREE_TIMES).forEach(i -> carRace.runRace());
                        List<Car> winners = carRace.getWinner();
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
                    int movingNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
                    int stopNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
                    assertThat(movingNumber).isEqualTo(MOVING_FORWARD);
                    assertThat(stopNumber).isEqualTo(STOP);
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
            CarRace carRace = new CarRace(cars, ONE_TIMES);

            assertRandomNumberInRangeTest(
                    () -> {
                        carRace.runRace();
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
            CarRace carRace = new CarRace(cars, THREE_TIMES);

            assertRandomNumberInRangeTest(
                    () -> {
                        IntStream.range(0, THREE_TIMES).forEach(i -> carRace.runRace());
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
