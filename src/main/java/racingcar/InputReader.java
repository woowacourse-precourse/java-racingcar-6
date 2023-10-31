package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.paser.InputCarNameParser;
import racingcar.paser.Parser;

public class InputReader {
    private Parser parser;

    public List<String> racingCar() {
        String readLine = Console.readLine();
        parser = new InputCarNameParser();
        List<String> carList = parser.parsing(readLine);
        return carList;
    }

    public String raceRound() {
        String readLine = Console.readLine();
        return readLine;
    }
}
