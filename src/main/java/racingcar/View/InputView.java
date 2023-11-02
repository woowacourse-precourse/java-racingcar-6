package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.Global.Constants;

public class InputView {


    private Boolean isStringSplitBySymbol(String str) {
        return str.split(Constants.splitSymbol).length >= 2
                || str.split(Constants.splitSymbol)[0].length() == str.length();
    }

    private List<String> splitString(String str) {
        if (!isStringSplitBySymbol(str)) {
            throw new IllegalArgumentException();
        }
        List<String> result = Arrays.asList(str.split(Constants.splitSymbol));
        return result;
    }

    public List<String> getCarsName() {
        return splitString(Console.readLine());
    }

    private Boolean isStringNumber(String str) {
        return str.matches("\\d+");
    }

    private int StringToInt(String str) {
        if (!isStringNumber(str)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(str);
    }

    public int getStageNumber() {
        return StringToInt(Console.readLine());
    }
}
