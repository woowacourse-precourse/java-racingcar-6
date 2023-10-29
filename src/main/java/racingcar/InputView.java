package racingcar;

import static racingcar.Validation.isNotNumber;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;


public class InputView {


    public ArrayList<String> getCarsName() {
        String carsName = Console.readLine();
        return Utils.splitCarName(carsName);
    }

    public String getTryNumber() {
        String tryNumber = Console.readLine();
        isNotNumber(tryNumber); //  사용자 입력 검증을 여기서 하는게 맞는지?
        return tryNumber;
    }
}
