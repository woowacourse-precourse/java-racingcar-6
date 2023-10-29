package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingSetting {
    CarNum carNum;
    MoveNum moveNum;

    String[] getName() {
        String inputCarName;
        String[] carNameParsing;

        inputCarName = Console.readLine();
        carNameParsing = inputCarName.split(",");
        carNum = new CarNum(carNameParsing);
        return (carNameParsing);
    }

    void getMoveNum() {
        String inputMoveNum;

        inputMoveNum = Console.readLine();
        moveNum = new MoveNum(inputMoveNum);
    }
}
