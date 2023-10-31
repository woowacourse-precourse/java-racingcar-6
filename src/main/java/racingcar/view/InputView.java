package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readRacersName() {
        return Console.readLine();
    }

    public static int readMoveNumber() {
        String strMoveNumber = Console.readLine();
        int moveNumber = Integer.parseInt(strMoveNumber);
        return moveNumber;
    }
}
