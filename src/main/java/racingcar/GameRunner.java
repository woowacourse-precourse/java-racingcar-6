package racingcar;

import racingcar.domain.car.GameCount;
import racingcar.domain.car.Name;
import racingcar.domain.car.NameParser;
import racingcar.io.ConsoleManager;
import racingcar.io.GameMessage;
import racingcar.util.StringConverter;

import java.util.List;

import static racingcar.util.StringConverter.*;

public class GameRunner {
    private final ConsoleManager consoleManager;
    private final NameParser nameParser;

    public GameRunner(){
        consoleManager = new ConsoleManager();
        nameParser = new NameParser();
    }

    public void run(){
        readCarNames();
        readGameCount();
    }

    private List<Name> readCarNames(){
        String line = consoleManager.readCarNames();
        return nameParser.parseName(line);
    }

    private GameCount readGameCount(){
        String strCount = consoleManager.readGameCount();
        return new GameCount(toInteger(strCount));
    }

}

