package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Utils;

public class InputView {

    public static String inputCarsNamesOfCars() {
        return Console.readLine();
    }

    public static int inputNumberOfMoves() {
        return Utils.convertStringToInt(Console.readLine());
    }
}
