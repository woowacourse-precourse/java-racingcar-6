package racingcar;

import static racingcar.Validation.isNotNumber;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;


public class InputView {

    public static ArrayList<String> getCarsName() {
        String carsName = Console.readLine();
        return splitCarName(carsName);
    }

    public static String getTryNumber() {
        String tryNumber = Console.readLine();
        isNotNumber(tryNumber); //  사용자 입력 검증을 여기서 하는게 맞는지?
        return tryNumber;
    }

    public static ArrayList<String> splitCarName(String input) {
        String[] stringList = input.split(",");
        ArrayList<String> result = new ArrayList<>(Arrays.asList(stringList));
        return result;
    }
}
