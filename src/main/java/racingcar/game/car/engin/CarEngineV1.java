package racingcar.game.car.engin;

import racingcar.game.enums.CarMove;
import racingcar.game.inputgenerateManager.InputGenerateManager;

public class CarEngineV1 implements CarEngine {
    private final InputGenerateManager inputGenerateManager;

    public CarEngineV1(InputGenerateManager inputGenerateManager) {
        this.inputGenerateManager = inputGenerateManager;
    }

    @Override
    public CarMove operateEngine() {
        Integer moveOrStopCondition = inputGenerateManager.generateRandomInt();
        return movingForward(moveOrStopCondition);
    }

    private CarMove movingForward(int moveOrStopCondition) {
        final int forwardCondition = 4;

        if (moveOrStopCondition >= forwardCondition) {
            return CarMove.MOVING_FORWARD;
        }
        return CarMove.STOP;
    }

}
