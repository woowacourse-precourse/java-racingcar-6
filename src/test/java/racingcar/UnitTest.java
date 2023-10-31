package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class UnitTest {

    private final Computer computer = new Computer();
    private static final int MOVE_FORWARD = 4;
    private static final int STOP = 3;

    @Nested
    @DisplayName("사용자는 경주에 참여할 자동차 이름을 입력한다.")
    class CarNameInputTest {

        @Test
        void 이름은_1자_이상이다() {
            assertDoesNotThrow(() -> computer.readCarNames("green"));
        }

        @Test
        void 이름은_5자_이하이다() {
            assertDoesNotThrow(() -> computer.readCarNames("green"));
        }

        @Test
        void 이름이_6자_이상일경우_예외발생() {
            assertThatIllegalArgumentException().isThrownBy(() -> computer.readCarNames("green2"));
        }

        @Test
        void 이름이_공백만으로_구성될경우_예외발생() {
            assertThatIllegalArgumentException().isThrownBy(() -> computer.readCarNames("   "));
        }

        @Test
        void 이름이_중복될경우_예외발생() {
            assertThatIllegalArgumentException().isThrownBy(() -> computer.readCarNames("green, green"));
        }

        @Test
        void 양쪽_공백은_제거된다() {
            assertDoesNotThrow(() -> computer.readCarNames(" green "));
        }

        @Test
        void 이름이_없을경우_예외발생() {
            assertThatIllegalArgumentException().isThrownBy(() -> computer.readCarNames("green,, red"));
        }
    }

    @Nested
    @DisplayName("사용자는 자동차 이동을 시도할 횟수를 입력한다.")
    class AttemptCountInputTest {

        @Test
        void 시도횟수는_1이상이다() {
            assertDoesNotThrow(() -> computer.readRound("1"));
        }

        @Test
        void 시도횟수가_음수이면_예외발생() {
            assertThatIllegalArgumentException().isThrownBy(() -> computer.readRound("-1"));
        }

        @Test
        void 시도횟수가_숫자가_아니면_예외발생() {
            assertThatIllegalArgumentException().isThrownBy(() -> computer.readRound("a"));
        }

        @Test
        void 시도횟수가_정수가_아니면_예외발생() {
            assertThatIllegalArgumentException().isThrownBy(() -> computer.readRound("1.1"));
        }
    }

    @Nested
    @DisplayName("컴퓨터는 이동 횟수에 대한 결과를 표시한다.")
    class RoundTest {

        @BeforeEach
        void setup() {
            computer.readCarNames("green");
            computer.readRound("1");
        }

        @Test
        void 무작위값이_4이상이면_전진() {
            Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        List<String> raceResult = computer.startRace();
                        System.out.println(raceResult);
                        assertThat(raceResult).contains("green : -");
                    },
                    MOVE_FORWARD
            );
        }

        @Test
        void 무작위값이_3이하이면_정지() {
            Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        List<String> raceResult = computer.startRace();
                        assertThat(raceResult).contains("green : ");
                    },
                    STOP
            );
        }

        @Test
        void 라운드별_실행결과_표시() {
            computer.readRound("3");

            Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        List<String> raceResult = computer.startRace();

                        assertThat(raceResult).contains("green : ---");
                        assertThat(raceResult).hasSize(3);
                    },
                    MOVE_FORWARD
            );
        }
    }

    @Nested
    @DisplayName("컴퓨터는 자동차 경주 게임을 완료한 후 누가 우승했는지를 표시한다.")
    class RaceWinnerTest {

        @BeforeEach
        void setup() {
            computer.readCarNames("green, red");
            computer.readRound("2");
        }

        @Test
        void 가장_많은_이동_횟수를_가진_자동차가_우승() {
            Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        computer.startRace();
                        List<String> raceWinners = computer.findWinner();
                        assertThat(raceWinners).contains("green");
                    },
                    MOVE_FORWARD, STOP, MOVE_FORWARD, STOP
            );
        }

        @Test
        void 이동_횟수가_동일할경우_모두_우승() {
            Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        computer.startRace();
                        List<String> raceWinners = computer.findWinner();
                        assertThat(raceWinners).contains("green", "red");
                    },
                    MOVE_FORWARD, MOVE_FORWARD, STOP, STOP
            );
        }

        @Test
        void 이동_횟수가_동일할경우_이름_입력_순서대로_표시() {
            computer.readCarNames("red, green");

            Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        computer.startRace();
                        List<String> raceWinners = computer.findWinner();
                        assertThat(raceWinners).contains("red", "green");
                    },
                    MOVE_FORWARD, MOVE_FORWARD, STOP, STOP
            );
        }
    }
}
