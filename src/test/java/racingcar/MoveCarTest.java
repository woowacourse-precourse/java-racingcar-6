package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.MoveCommandMaker;
import racingcar.infra.MoveCommandMakerImpl;

public class MoveCarTest {

    private final MoveCommandMaker moveCommandMaker = new MoveCommandMakerImpl();

    @Test
    @DisplayName("전진 명령 테스트")
    public void testCommandMoveForward() {
        Car car = new Car("me");

        car.move(moveCommandMaker.makeMoveCommand(5));
        car.move(moveCommandMaker.makeMoveCommand(7));

        Assertions.assertEquals(2, car.getPosition());
    }

    @Test
    @DisplayName("정지 명령 테스트")
    public void testCommandStop() {
        Car car = new Car("me");

        car.move(moveCommandMaker.makeMoveCommand(0));
        car.move(moveCommandMaker.makeMoveCommand(3));

        Assertions.assertEquals(0, car.getPosition());
    }
}
