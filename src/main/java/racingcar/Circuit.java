package racingcar;

import racingcar.common.util.InputUtil;
import racingcar.common.util.OutputUtil;

import java.util.List;

import static racingcar.common.message.GameConstant.INIT_PRINT_GAME_RESULT_MESSAGE;

public class Circuit {
    private final InputUtil inputUtil;
    private final OutputUtil outputUtil;
    private final Refree refree;

    public Circuit(InputUtil inputUtil, OutputUtil outputUtil, Refree refree) {
        this.inputUtil = inputUtil;
        this.outputUtil = outputUtil;
        this.refree = refree;
    }


    public List<Car> start() {
        List<Car> cars = inputUtil.inputCarNames();
        int attemptNumber = inputUtil.inputAttemptNumber();
        playAllGames(cars, attemptNumber);
        award(cars);
        return cars;
    }

    private void playAllGames(List<Car> cars, int attemptNumber) {
        System.out.println(INIT_PRINT_GAME_RESULT_MESSAGE);
        for (int i = 0; i < attemptNumber; i++) {
            playEachGame(cars);
            outputUtil.readResult(cars);
        }
    }

    private void playEachGame(List<Car> cars) {
        for (Car car : cars) {
            int randomGameNumber = Computer.getNumber();
            if (refree.verifyPickNumber(randomGameNumber)) {
                car.countUpGo();
            }
        }
    }

    private void award(List<Car> cars) {
        refree.calculateFinalResult(cars);
        outputUtil.readWinner(cars);
    }
}
