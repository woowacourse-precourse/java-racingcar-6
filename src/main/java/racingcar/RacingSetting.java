package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingSetting {
    MoveNum moveNum;

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
        moveNum = new MoveNum(inputMoveNum);
    }
}
