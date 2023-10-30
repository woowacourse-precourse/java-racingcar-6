package car;

import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.view.GameView;

public class CarControlTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 랜덤_숫자가_3이면_정지한다() {
        GameController gameController = new GameController(new GameView());
        Car car = new Car("jay");



    }
}
