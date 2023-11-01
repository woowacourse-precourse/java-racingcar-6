package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputConsoleTest extends NsTest {

    public static final int MOVING_FORWARD = 4;
    public static final int STOP = 3;

    @Nested
    class 출력_테스트 {
        @Test
        public void 시도횟수_문구_출력_테스트() throws Exception {
            OutputConsole.print(OutputConsole.ROUND_MESSAGE);
            Assertions.assertThat(output()).contains(OutputConsole.ROUND_MESSAGE);
        }

        @Test
        public void 이름_문구_출력_테스트() throws Exception {
            OutputConsole.print(OutputConsole.CAR_NAME_MESSAGE);
            Assertions.assertThat(output()).contains(OutputConsole.CAR_NAME_MESSAGE);
        }

        @Test
        public void 실행_결과_출력_테스트() throws Exception {
            Status status1 = new Status("pobi", 1);
            Status status2 = new Status("woni", 0);
            Status status3 = new Status("jun", 1);

            OutputConsole.printStatus(List.of(status1, status2, status3));
            Assertions.assertThat(output()).contains("pobi : -", "woni : ", "jun : -");
        }

        @Test
        public void 우승자_여러명_일때_출력_테스트() throws Exception {
            Car car1 = new Car("pobi");
            Car car2 = new Car("woni");
            Car car3 = new Car("jun");

            int expectedRound = 5;

            Race race = new Race(3, List.of(car1, car2, car3));

            camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        Randoms.pickNumberInRange(0, 9);
                        for (int i = 0; i < expectedRound; i++) {
                            race.proceedRound();
                        }
                        OutputConsole.printWinners(race.getSameDistanceCars(race.getMaxDistance()));
                        Assertions.assertThat(output()).contains(OutputConsole.WINNER_MESSAGE, OutputConsole.PARTITION,"pobi", "jun");
                    },
                    STOP,
                    MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
            );
        }

        @Test
        public void 우승자_한명일때_출력_테스트() throws Exception {
            Car car1 = new Car("pobi");
            Car car2 = new Car("woni");
            Car car3 = new Car("jun");

            int expectedRound = 3;

            Race race = new Race(3, List.of(car1, car2, car3));

            camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        Randoms.pickNumberInRange(0, 9);
                        for (int i = 0; i < expectedRound; i++) {
                            race.proceedRound();
                        }
                        OutputConsole.printWinners(race.getSameDistanceCars(race.getMaxDistance()));
                        Assertions.assertThat(output()).contains(OutputConsole.WINNER_MESSAGE, OutputConsole.PARTITION,"pobi");
                    },
                    STOP,
                    MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP, STOP
            );
        }
             
    }

    @Override
    protected void runMain() {

    }

}