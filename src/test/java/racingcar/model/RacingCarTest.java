package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RacingCarTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Override
    protected void runMain() {
        // do nothing
    }

    @Nested
    @DisplayName("자동차 이름 테스트")
    class TestName {
        @Test
        @DisplayName("올바른 이름에 대한 인스턴스를 생성한다.")
        void success() {
            // given
            String name = "test";

            // when
            RacingCar racingCar = new RacingCar(name);

            // then
            assertThat(racingCar.getName()).isEqualTo(name);
        }

        @Test
        @DisplayName("이름이 빈 문자열인 자동차를 생성할 수 없다.")
        void failToEmptyName() {
            // given
            String name = "";

            // when
            ThrowingCallable target = () -> new RacingCar(name);

            // then
            assertThatIllegalArgumentException().isThrownBy(target)
                    .withMessage("자동차 이름은 빈 문자열이 될 수 없습니다.");
        }

        @Test
        @DisplayName("이름이 5글자를 초과한 자동차를 생성할 수 없다.")
        void failToLongName() {
            // given
            String name = "testCar";

            // when
            ThrowingCallable target = () -> new RacingCar(name);

            // then
            assertThatIllegalArgumentException().isThrownBy(target)
                    .withMessage("자동차 이름은 5글자 이하만 가능합니다.");
        }
    }

    @Nested
    @DisplayName("자동차 출발 정지 테스트")
    class TestStart {
        @Test
        @DisplayName("난수가 4 이상일 때 자동차는 출발한다.")
        void start() {
            // given
            RacingCar racingCar = new RacingCar("test");

            // when
            int randomNumber = MOVING_FORWARD;

            // then
            assertRandomNumberInRangeTest(
                    () -> {
                        racingCar.start();

                        int currentLap = racingCar.getLap();

                        assertThat(currentLap).isEqualTo(2);
                    },
                    randomNumber
            );
        }

        @Test
        @DisplayName("난수가 4 미만일 때 자동차는 정지한다.")
        void stop() {
            // given
            RacingCar racingCar = new RacingCar("test");

            // when
            int randomNumber = STOP;

            // then
            assertRandomNumberInRangeTest(
                    () -> {
                        racingCar.start();

                        int currentLap = racingCar.getLap();

                        assertThat(currentLap).isEqualTo(1);
                    },
                    STOP
            );
        }
    }

    @Nested
    @DisplayName("자동차 경주 상태 테스트")
    class TestRaceState {
        @Test
        @DisplayName("자동차의 경주 상태에는 이름이 포함된다.")
        void stateStartWith() {
            // given
            String name = "test";
            RacingCar racingCar = new RacingCar(name);

            // when
            String raceState = racingCar.raceState();

            // then
            assertThat(raceState).startsWith("%s : ".formatted(name));
        }

        @Test
        @DisplayName("자동차의 경주 상태는 완주한 lap의 정보가 포함된다.")
        void stateWithStateBar() {
            // given
            String name = "test";
            RacingCar racingCar = new RacingCar(name);

            // finish 2 lap
            assertRandomNumberInRangeTest(
                    () -> {
                        racingCar.start();
                        racingCar.start();
                    },
                    MOVING_FORWARD, MOVING_FORWARD);

            // when
            String raceState = racingCar.raceState();

            // then
            assertThat(raceState).isEqualTo("%s : --".formatted(name));
        }
    }

    @Test
    @DisplayName("자동차가 현재 주행 중인 lap과 동일한 경우 true를 반환한다.")
    void testIsSameLap() {
        // given
        int finishedLapCount = 3;
        int currentLap = finishedLapCount + 1;
        RacingCar racingCar = new RacingCar("test");

        // finish 3 lap
        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 1; i <= finishedLapCount; i++) {
                        racingCar.start();
                    }
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD);

        // when
        boolean isSameLap = racingCar.isSameLap(currentLap);

        // then
        assertThat(isSameLap).isTrue();
    }
}
