package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingSetting {

    String[] getName() {
        String inputCarName;
        String[] carNameParsing;

        inputCarName = readLine();
        carNameParsing = inputCarName.split(",");
        return (carNameParsing);
    }

    void getMoveNum() {
        String inputMoveNum;

        inputMoveNum = readLine();
    }
}
