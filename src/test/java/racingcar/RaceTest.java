package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
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

    @Nested
    class 가장_멀리온_차의_거리_리턴 {
        static Car car1;
        static Car car2;
        static Car car3;

        static Race race;

        static int expectedRound = 3;

        @Test
        public void 모두_같은_경우() throws Exception {
            car1 = new Car("alpha");
            car2 = new Car("bravo");
            car3 = new Car("char");

            List<Car> expectedCars = Arrays.asList(car1, car2, car3);
            race = new Race(3, List.of(car1, car2, car3));

            camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        for (int i = 0; i < expectedRound; i++) {
                            race.proceedRound();
                        }
                        Assertions.assertThat(race.getMaxDistance()).isEqualTo(0);
                    },
                    STOP,
                    STOP
            );
        }

        @Test
        public void 두개가_같은_경우() throws Exception {
            car1 = new Car("alpha");
            car2 = new Car("bravo");
            car3 = new Car("char");

            List<Car> expectedCars = Arrays.asList(car1, car2, car3);
            race = new Race(3, List.of(car1, car2, car3));

            camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        Randoms.pickNumberInRange(0, 9);
                        for (int i = 0; i < expectedRound; i++) {
                            race.proceedRound();
                        }
                        Assertions.assertThat(race.getMaxDistance()).isEqualTo(3);
                    },
                    STOP,
                    MOVING_FORWARD
            );
        }

        @Test
        public void 모두_다른_경우() throws Exception {
            car1 = new Car("alpha");
            car2 = new Car("bravo");
            car3 = new Car("char");

            List<Car> expectedCars = Arrays.asList(car1, car2, car3);
            race = new Race(3, List.of(car1, car2, car3));

            camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        Randoms.pickNumberInRange(0, 9);
                        for (int i = 0; i < expectedRound; i++) {
                            race.proceedRound();
                        }
                        Assertions.assertThat(race.getMaxDistance()).isEqualTo(3);
                    },
                    STOP,
                    MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP, STOP
            );
        }
    }

    @Nested
    class 거리가_같은_차량_리턴_테스트 {
        static Car car1;
        static Car car2;
        static Car car3;

        static Race race;

        static int expectedRound = 3;

        @Test
        public void 모두_같은_경우() throws Exception {
            car1 = new Car("alpha");
            car2 = new Car("bravo");
            car3 = new Car("char");

            List<Car> expectedCars = Arrays.asList(car1, car2, car3);
            race = new Race(3, List.of(car1, car2, car3));

            camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        for (int i = 0; i < expectedRound; i++) {
                            race.proceedRound();
                        }
                        Assertions.assertThat(race.getSameDistanceCars(0)).containsAll(expectedCars);
                    },
                    STOP,
                    STOP
            );
        }

        @Test
        public void 두개가_같은경우() throws Exception {
            car1 = new Car("alpha");
            car2 = new Car("bravo");
            car3 = new Car("char");

            List<Car> expectedCars = Arrays.asList(car2, car3);
            race = new Race(3, List.of(car1, car2, car3));

            camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        for (int i = 0; i < expectedRound; i++) {
                            race.proceedRound();
                        }
                        Assertions.assertThat(race.getSameDistanceCars(3)).containsAll(expectedCars);
                    },
                    STOP,
                    MOVING_FORWARD
            );
        }

        @Test
        public void 모두_다른_경우() throws Exception {
            car1 = new Car("alpha");
            car2 = new Car("bravo");
            car3 = new Car("char");

            List<Car> expectedCars = Arrays.asList(car1, car2, car3);
            race = new Race(3, List.of(car1, car2, car3));

            camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        Randoms.pickNumberInRange(0, 9);
                        for (int i = 0; i < expectedRound; i++) {
                            race.proceedRound();
                        }
                        Assertions.assertThat(race.getSameDistanceCars(3)).containsAll(List.of(car1));
                        Assertions.assertThat(race.getSameDistanceCars(1)).containsAll(List.of(car2));
                        Assertions.assertThat(race.getSameDistanceCars(0)).containsAll(List.of(car3));
                    },
                    STOP,
                    MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP, STOP
            );
        }
    }

    @Nested
    class 현재_결과_리턴_테스트 {
        static Car car1;
        static Car car2;
        static Car car3;

        static Race race;

        static int expectedRound = 3;

        @Test
        public void 모두_같은_경우() throws Exception {
            car1 = new Car("alpha");
            car2 = new Car("bravo");
            car3 = new Car("char");

            List<Car> expectedCars = Arrays.asList(car1, car2, car3);
            race = new Race(3, List.of(car1, car2, car3));

            camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        for (int i = 0; i < expectedRound; i++) {
                            race.proceedRound();
                        }
                        Assertions.assertThat(race.getCurrentStatus()).extracting("name", "distance")
                                .isEqualTo(List.of(
                                        Tuple.tuple("alpha", 0),
                                        Tuple.tuple("bravo", 0),
                                        Tuple.tuple("char", 0)));
                    },
                    STOP,
                    STOP
            );
        }

        @Test
        public void 두개가_같은경우() throws Exception {
            car1 = new Car("alpha");
            car2 = new Car("bravo");
            car3 = new Car("char");

            List<Car> expectedCars = Arrays.asList(car2, car3);
            race = new Race(3, List.of(car1, car2, car3));

            camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        for (int i = 0; i < expectedRound; i++) {
                            race.proceedRound();
                        }
                        Assertions.assertThat(race.getCurrentStatus()).extracting("name", "distance")
                                .isEqualTo(List.of(
                                        Tuple.tuple("alpha", 2),
                                        Tuple.tuple("bravo", 3),
                                        Tuple.tuple("char", 3)));
                    },
                    STOP,
                    MOVING_FORWARD
            );
        }

        @Test
        public void 모두_다른_경우() throws Exception {
            car1 = new Car("alpha");
            car2 = new Car("bravo");
            car3 = new Car("char");

            List<Car> expectedCars = Arrays.asList(car1, car2, car3);
            race = new Race(3, List.of(car1, car2, car3));

            camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        Randoms.pickNumberInRange(0, 9);
                        for (int i = 0; i < expectedRound; i++) {
                            race.proceedRound();
                        }

                        Assertions.assertThat(race.getCurrentStatus()).extracting("name", "distance")
                                .isEqualTo(List.of(
                                        Tuple.tuple("alpha", 3),
                                        Tuple.tuple("bravo", 1),
                                        Tuple.tuple("char", 0)));
                    },
                    STOP,
                    MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP, STOP
            );
        }
    }

    @Nested
    class 우승자를_뽑는_기능 {
        static Car car1;
        static Car car2;
        static Car car3;

        static Race race;

        static int expectedRound = 3;

        @Test
        public void 모두_같은_경우() throws Exception {
            car1 = new Car("alpha");
            car2 = new Car("bravo");
            car3 = new Car("char");

            List<Car> expectedCars = Arrays.asList(car1, car2, car3);
            race = new Race(3, List.of(car1, car2, car3));

            camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        for (int i = 0; i < expectedRound; i++) {
                            race.proceedRound();
                        }
                        Assertions.assertThat(race.getWinners()).extracting("name", "distance")
                                .isEqualTo(List.of(
                                        Tuple.tuple("alpha", 0),
                                        Tuple.tuple("bravo", 0),
                                        Tuple.tuple("char", 0)));
                    },
                    STOP,
                    STOP
            );
        }

        @Test
        public void 두개가_같은경우() throws Exception {
            car1 = new Car("alpha");
            car2 = new Car("bravo");
            car3 = new Car("char");

            List<Car> expectedCars = Arrays.asList(car2, car3);
            race = new Race(3, List.of(car1, car2, car3));

            camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        for (int i = 0; i < expectedRound; i++) {
                            race.proceedRound();
                        }
                        Assertions.assertThat(race.getWinners()).extracting("name", "distance")
                                .isEqualTo(List.of(
                                        Tuple.tuple("bravo", 3),
                                        Tuple.tuple("char", 3)));
                    },
                    STOP,
                    MOVING_FORWARD
            );
        }

        @Test
        public void 모두_다른_경우() throws Exception {
            car1 = new Car("alpha");
            car2 = new Car("bravo");
            car3 = new Car("char");

            List<Car> expectedCars = Arrays.asList(car1, car2, car3);
            race = new Race(3, List.of(car1, car2, car3));

            camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        Randoms.pickNumberInRange(0, 9);
                        for (int i = 0; i < expectedRound; i++) {
                            race.proceedRound();
                        }

                        Assertions.assertThat(race.getWinners()).extracting("name", "distance")
                                .isEqualTo(List.of(
                                        Tuple.tuple("alpha", 3)));
                    },
                    STOP,
                    MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP, STOP
            );
        }
    }

}