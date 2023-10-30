package racingcar.domain.system.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.domain.system.game.RacingGameTest.GameTestFactory.getCoWinnerTestHost;
import static racingcar.domain.system.game.RacingGameTest.GameTestFactory.getConsoleViewer;
import static racingcar.domain.system.game.RacingGameTest.GameTestFactory.getTestCarManager;
import static racingcar.domain.system.game.RacingGameTest.GameTestFactory.getTestCarNameReader;
import static racingcar.domain.system.game.RacingGameTest.GameTestFactory.getTestCarPositionManager;
import static racingcar.domain.system.game.RacingGameTest.GameTestFactory.getTestHost;
import static racingcar.domain.system.game.RacingGameTest.GameTestFactory.getTestTryCountReader;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.core.car.MoveSignal;
import racingcar.domain.core.car.MovingCar;
import racingcar.domain.core.car.OnRaceCar;
import racingcar.domain.system.host.Host;
import racingcar.domain.system.manager.car.CarManager;
import racingcar.domain.system.manager.car.InMemoryCarManager;
import racingcar.domain.system.manager.car.value.SavedCar;
import racingcar.domain.system.manager.position.CarPositionManager;
import racingcar.domain.system.manager.position.InMemoryCarPositionManager;
import racingcar.domain.system.manager.position.value.SavedCarPosition;
import racingcar.domain.system.reader.CarNameReader;
import racingcar.domain.system.reader.TryCountReader;
import racingcar.domain.system.viewer.ConsoleViewer;
import racingcar.domain.system.viewer.Viewer;

class RacingGameTest {

    private static final Long MOVE = 5L;
    private static final Long STOP = 1L;
    private static final String CAR_A_NAME = "a";
    private static final String CAR_B_NAME = "b";
    private static final String CAR_C_NAME = "c";
    private static final int CAR_A_POSITION = 3;
    private static final int CAR_B_POSITION = 2;
    private static final int CAR_C_POSITION = 1;
    private static final int COWINNER_CAR_A_POSITION = 3;
    private static final int COWINNER_CAR_B_POSITION = COWINNER_CAR_A_POSITION;
    private static final int COWINNER_CAR_C_POSITION = 1;
    private static final int[] EXPECTED_POSITIONS = {CAR_A_POSITION, CAR_B_POSITION,
        CAR_C_POSITION};
    private static final int[] COWINNER_EXPECTED_POSITIONS = {COWINNER_CAR_A_POSITION,
        COWINNER_CAR_B_POSITION, COWINNER_CAR_C_POSITION};

    @Test
    @DisplayName("게임을 시작한다.")
    void start() {
        // given
        CarNameReader carNameReader = getTestCarNameReader();
        TryCountReader tryCountReader = getTestTryCountReader();
        Viewer viewer = getConsoleViewer();
        Host host = getTestHost();
        CarManager carManager = getTestCarManager();
        CarPositionManager carPositionManager = getTestCarPositionManager();
        Game game = new RacingGame(carNameReader, tryCountReader, viewer, host, carManager,
            carPositionManager);

        // when
        game.start();

        // then
        List<SavedCar> cars = carManager.findAll();
        List<SavedCarPosition> positions = carPositionManager.findAll(cars);
        int idx = 0;
        for (SavedCarPosition position : positions) {
            assertEquals(EXPECTED_POSITIONS[idx++], position.getPosition());
        }
    }

    @Test
    @DisplayName("공동 우승자가 있는 게임을 시작한다.")
    void coWinnerStart() {
        // given
        CarNameReader carNameReader = getTestCarNameReader();
        TryCountReader tryCountReader = getTestTryCountReader();
        Viewer viewer = getConsoleViewer();
        Host host = getCoWinnerTestHost();
        CarManager carManager = getTestCarManager();
        CarPositionManager carPositionManager = getTestCarPositionManager();
        Game game = new RacingGame(carNameReader, tryCountReader, viewer, host, carManager,
            carPositionManager);

        // when
        game.start();

        // then
        List<SavedCar> cars = carManager.findAll();
        List<SavedCarPosition> positions = carPositionManager.findAll(cars);
        int idx = 0;
        for (SavedCarPosition position : positions) {
            assertEquals(COWINNER_EXPECTED_POSITIONS[idx++], position.getPosition());
        }
    }

    static class GameTestFactory {

        static CarNameReader getTestCarNameReader() {
            return () -> List.of(CAR_A_NAME, CAR_B_NAME, CAR_C_NAME);
        }

        static TryCountReader getTestTryCountReader() {
            return () -> 3L;
        }

        static Viewer getConsoleViewer() {
            return new ConsoleViewer();
        }

        static Host getTestHost() {
            return new TestHost();
        }

        static Host getCoWinnerTestHost() {
            return new CoWinnerTestHost();
        }

        static CarManager getTestCarManager() {
            return new InMemoryCarManager();
        }

        static CarPositionManager getTestCarPositionManager() {
            return new InMemoryCarPositionManager();
        }
    }

    private static class TestHost extends Host {

        /**
         * 행 : 라운드 차수(총 : 3회), 열 : 자동차(A, B, C), 값 : 자동차의 이동 신호, 결과 : A(3), B(2), C(1)
         */
        private static final Long[] MOVE_DATA = {MOVE, STOP, STOP, MOVE, MOVE, STOP, MOVE, MOVE,
            MOVE};
        private static int idx = 0;

        @Override
        public OnRaceCar signal(MovingCar car) {
            return car.move(getSignal());
        }

        @Override
        protected MoveSignal getSignal() {
            return MoveSignal.of(MOVE_DATA[idx++]);
        }
    }

    private static class CoWinnerTestHost extends Host {

        /**
         * 행 : 라운드 차수(총 : 3회), 열 : 자동차(A, B, C), 값 : 자동차의 이동 신호, 결과 : A(3), B(3), C(1)
         */
        private static final Long[] MOVE_DATA = {MOVE, MOVE, STOP, MOVE, MOVE, STOP, MOVE,
            MOVE, MOVE};
        private static int idx = 0;

        @Override
        public OnRaceCar signal(MovingCar car) {
            return car.move(getSignal());
        }

        @Override
        protected MoveSignal getSignal() {
            return MoveSignal.of(MOVE_DATA[idx++]);
        }
    }
}