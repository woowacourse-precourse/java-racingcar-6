package racingcar.View;

import static racingcar.Utils.splitCarName;
import static racingcar.Validation.endsWithComma;
import static racingcar.Validation.isEmpty;
import static racingcar.Validation.isNotNumber;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;


public class InputView {

    public ArrayList<String> getCarsName() {
        String carsName = Console.readLine();
        endsWithComma(carsName);
        isEmpty(carsName);
        ArrayList<String> carNameList = splitCarName(carsName);
        return carNameList;
    }

    public String getTryNumber() {
        String tryNumber = Console.readLine();
        isEmpty(tryNumber);
        isNotNumber(tryNumber);
        return tryNumber;
    }
}
