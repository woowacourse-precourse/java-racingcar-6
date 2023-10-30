package racingcar.domain.system.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.core.car.MoveSignal;
import racingcar.domain.core.car.OnRaceCar;
import racingcar.domain.core.car.MovingCar;
import racingcar.domain.system.host.Host;
import racingcar.domain.system.manager.car.InMemoryCarManager;
import racingcar.domain.system.manager.car.value.SavedCar;
import racingcar.domain.system.manager.position.CarPositionManager;
import racingcar.domain.system.manager.position.InMemoryCarPositionManager;
import racingcar.domain.system.manager.position.value.SavedCarPosition;
import racingcar.domain.system.reader.CarNameReader;
import racingcar.domain.system.reader.TryCountReader;
import racingcar.initializer.ConsoleGameFactory;

class RacingGameTest {

    private static final String CAR_A_NAME = "a";
    private static final String CAR_B_NAME = "b";
    private static final String CAR_C_NAME = "c";
    private static final int CAR_A_POSITION = 3;
    private static final int CAR_B_POSITION = 2;
    private static final int CAR_C_POSITION = 1;
    private static final Long MOVE = 5L;
    private static final Long STOP = 1L;

    /**
     * 행 : 라운드 차수(총 : 3회), 열 : 자동차(A, B, C), 값 : 자동차의 이동 신호, 결과 : A(3), B(2), C(1)
     */
    private static final Long[] MOVE_DATA = {MOVE, STOP, STOP, MOVE, MOVE, STOP, MOVE, MOVE, MOVE};
    private static final int[] EXPECTED_POSITIONS = {CAR_A_POSITION, CAR_B_POSITION,
        CAR_C_POSITION};

    @Test
    @DisplayName("게임을 시작한다.")
    void start() {
        // given
        TestCarNameReader carNameReader = new TestCarNameReader();
        TestTryCountReader tryCountReader = new TestTryCountReader();
        TestHost host = new TestHost();
        ConsoleGameFactory factory = new ConsoleGameFactory();
        InMemoryCarManager carManager = new InMemoryCarManager();
        CarPositionManager carPositionManager = new InMemoryCarPositionManager();

        Game game = new RacingGame(carNameReader, tryCountReader, factory.getViewer(), host,
            carManager, carPositionManager);

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

    private static class TestCarNameReader implements CarNameReader {

        @Override
        public List<String> read() {
            return List.of(CAR_A_NAME, CAR_B_NAME, CAR_C_NAME);
        }
    }

    private static class TestTryCountReader implements TryCountReader {

        @Override
        public Long read() {
            return 3L;
        }
    }

    private static class TestHost extends Host {

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