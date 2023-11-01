package racingcar.game;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

class RacingGameTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Override
    protected void runMain() {
        // do nothing
    }

    @Nested
    @DisplayName("게임 초기 설정 테스트")
    class TestConstruct {
        @Test
        @DisplayName("올바른 자동차와 시도 횟수가 주어졌을 때 인스턴스를 생성한다.")
        void success() {
            // given
            List<RacingCar> racingCars = List.of(
                    new RacingCar("ann"),
                    new RacingCar("bob"),
                    new RacingCar("chris")
            );
            int endLap = 5;

            // when
            ThrowingCallable target = () -> new RacingGame(racingCars, endLap);

            // then
            assertThatNoException().isThrownBy(target);
        }

        @Test
        @DisplayName("자동차가 존재하지 않을 경우 예외를 발생한다.")
        void failToEmptyCars() {
            // given
            List<RacingCar> racingCars = Collections.emptyList();
            int endLap = 5;

            // when
            ThrowingCallable target = () -> new RacingGame(racingCars, endLap);

            // then
            assertThatIllegalArgumentException().isThrownBy(target)
                    .withMessage("자동차가 존재하지 않습니다.");
        }

        @Test
        @DisplayName("중복된 자동차 이름이 존재할 경우 예외를 발생한다.")
        void failToDuplicateCarName() {
            // given
            List<RacingCar> racingCars = List.of(
                    new RacingCar("ann"),
                    new RacingCar("bob"),
                    new RacingCar("bob")
            );
            int endLap = 5;

            // when
            ThrowingCallable target = () -> new RacingGame(racingCars, endLap);

            // then
            assertThatIllegalArgumentException().isThrownBy(target)
                    .withMessage("자동차 이름은 중복될 수 없습니다.");
        }

        @Test
        @DisplayName("양수가 아닌 시도 횟수의 경우 예외를 발생한다.")
        void failToNonPositiveEndLap() {
            // given
            List<RacingCar> racingCars = List.of(
                    new RacingCar("ann"),
                    new RacingCar("bob"),
                    new RacingCar("chris")
            );
            int endLap = 0;

            // when
            ThrowingCallable target = () -> new RacingGame(racingCars, endLap);

            // then
            assertThatIllegalArgumentException().isThrownBy(target)
                    .withMessage("시도 횟수는 1보다 작을 수 없습니다.");
        }
    }

    @Nested
    @DisplayName("게임 실행 테스트")
    class TestRun {
        @Test
        @DisplayName("각 lap에 대한 결과를 출력한다.")
        void printLapResult() {
            // given
            List<RacingCar> racingCars = List.of(
                    new RacingCar("ann"),
                    new RacingCar("bob")
            );
            int endLap = 2;

            RacingGame racingGame = new RacingGame(racingCars, endLap);

            // when
            assertRandomNumberInRangeTest(
                    racingGame::run,
                    MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP
            );

            // then
            assertThat(output()).contains(
                    "ann : -",
                    "bob : ",
                    "ann : --",
                    "bob : -"
            );
        }

        @Test
        @DisplayName("레이싱 결과에 대한 최종 결과를 출력한다.")
        void printRaceResult() {
            // given
            List<RacingCar> racingCars = List.of(
                    new RacingCar("ann"),
                    new RacingCar("bob")
            );
            int endLap = 2;

            RacingGame racingGame = new RacingGame(racingCars, endLap);

            // when
            assertRandomNumberInRangeTest(
                    racingGame::run,
                    MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP
            );

            // then
            assertThat(output()).endsWith("최종 우승자 : ann");
        }

        @Test
        @DisplayName("동점자가 있을 경우 모든 자동차 이름을 출력한다.")
        void printRaceResultCoWinners() {
            // given
            List<RacingCar> racingCars = List.of(
                    new RacingCar("ann"),
                    new RacingCar("bob")
            );
            int endLap = 2;

            RacingGame racingGame = new RacingGame(racingCars, endLap);

            // when
            assertRandomNumberInRangeTest(
                    racingGame::run,
                    MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
            );

            // then
            assertThat(output()).satisfiesAnyOf(
                    output -> assertThat(output).endsWith("최종 우승자 : ann, bob"),
                    output -> assertThat(output).endsWith("최종 우승자 : bob, bob")
            );
        }
    }
}
