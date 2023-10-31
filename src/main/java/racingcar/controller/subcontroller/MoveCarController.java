package racingcar.controller.subcontroller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

public class MoveCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public MoveCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void moveCar(Car car) {
        int rand = Randoms.pickNumberInRange(0, 9);
        if (rand >= 4) {
            car.addMoveCount();
        }
    }
}