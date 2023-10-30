package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Commander;
import racingcar.domain.MoveCarType;
import racingcar.domain.MoveCommandMaker;
import racingcar.infra.CommanderImpl;

public class CommanderTest {

    private final Commander commander = new CommanderImpl();

    @Test
    @DisplayName("전진 명령 테스트")
    public void testCommandMoveForward() {
        Car car = new Car("me");

        commander.moveCar(car, new ForwardCommander());

        Assertions.assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("정지 명령 테스트")
    public void testCommandStop() {
        Car car = new Car("me");

        commander.moveCar(car, new StopCommander());

        Assertions.assertEquals(0, car.getPosition());
    }

    public static class ForwardCommander implements MoveCommandMaker {

        @Override
        public MoveCarType makeMoveCommand() {
            return MoveCarType.FORWARD;
        }
    }

    public static class StopCommander implements MoveCommandMaker {

        @Override
        public MoveCarType makeMoveCommand() {
            return MoveCarType.STOP;
        }
    }
}
