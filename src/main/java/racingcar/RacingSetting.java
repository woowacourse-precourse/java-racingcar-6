package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingSetting {
    CarNum carNum;
    MoveNum moveNum;

    String[] getName() {
        String inputCarName;
        String[] carNameParsing;

        inputCarName = readLine();
        carNameParsing = inputCarName.split(",");
        carNum = new CarNum(carNameParsing);
        return (carNameParsing);
    }

    void getMoveNum() {
        String inputMoveNum;

        inputMoveNum = readLine();
        moveNum = new MoveNum(inputMoveNum);
    }
}
