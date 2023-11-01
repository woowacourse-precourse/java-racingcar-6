package racingcar;

import racingcar.domain.car.Name;
import racingcar.domain.car.NameParser;
import racingcar.io.ConsoleManager;
import racingcar.io.GameMessage;

import java.util.List;

public class GameRunner {
    private final ConsoleManager consoleManager;
    private final NameParser nameParser;

    public GameRunner(){
        consoleManager = new ConsoleManager();
        nameParser = new NameParser();
    }

    public void run(){
        readCarNames();
    }

    private List<Name> readCarNames(){
        consoleManager.printGameMessage(GameMessage.INPUT_CAR_NAMES_MESSAGE);
        String line = consoleManager.readCarNames();
        return nameParser.parseName(line);
    }

}

