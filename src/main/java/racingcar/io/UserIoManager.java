package racingcar.io;

import java.util.List;
import racingcar.domain.car.Cars;
import racingcar.domain.judge.WinnerCars;
import racingcar.io.input.InputManager;
import racingcar.io.output.ConsoleWriter;

public class UserIoManager {

    private final InputManager inputManager;
    private final ConsoleWriter consoleWriter;
    private boolean isFirstMoveResultNotification = true;

    public UserIoManager(InputManager inputManager, ConsoleWriter consoleWriter) {
        this.inputManager = inputManager;
        this.consoleWriter = consoleWriter;
    }

    public List<String> readCarNames() {
        consoleWriter.printCarNameInputGuide();
        return inputManager.readCarNames();
    }

    public long readMovingCount() {
        consoleWriter.printMovingCountInputGuide();
        return inputManager.readMovingCount();
    }

    public void notifyMoveResult(Cars cars) {
        if (this.isFirstMoveResultNotification) {
            consoleWriter.printExecutionResultMessage();
            this.isFirstMoveResultNotification = false;
        }
        consoleWriter.printMoveResult(cars);
    }

    public void notifyWinner(WinnerCars winnerCars) {
        consoleWriter.printWinnerResult(winnerCars);
    }

}
