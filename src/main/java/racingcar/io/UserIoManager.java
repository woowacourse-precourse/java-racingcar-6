package racingcar.io;

import java.util.List;
import racingcar.domain.car.Cars;
import racingcar.io.input.ConsoleReader;
import racingcar.io.output.ConsoleWriter;

public class UserIoManager {

    private final ConsoleReader consoleReader;
    private final ConsoleWriter consoleWriter;
    private boolean isFirstMoveResultNotification = true; // FIXME flag 값 없애기

    public UserIoManager(ConsoleReader consoleReader, ConsoleWriter consoleWriter) {
        this.consoleReader = consoleReader;
        this.consoleWriter = consoleWriter;
    }

    public List<String> readCarNames() {
        consoleWriter.printCarNameInputGuide();
        return consoleReader.readCarNames();
    }

    public long readMovingCount() {
        consoleWriter.printMovingCountInputGuide();
        return consoleReader.readMovingCount();
    }

    public void notifyMoveResult(Cars cars) {
        if (this.isFirstMoveResultNotification) {
            consoleWriter.printExecutionResultMessage();
            this.isFirstMoveResultNotification = false;
        }
        consoleWriter.printMoveResult(cars);
    }

}
