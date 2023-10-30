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
        ArrayList<String> carNameList = splitCarName(carsName);
        isEmpty(carNameList);
        return carNameList;
    }

    public String getTryNumber() {
        String tryNumber = Console.readLine();
        isNotNumber(tryNumber); //  사용자 입력 검증을 여기서 하는게 맞는지?
        return tryNumber;
    }
}
