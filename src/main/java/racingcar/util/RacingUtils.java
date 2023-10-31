package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class RacingUtils {

    final String NUM_REG = "[0-9]+";

    public String getInputAnswerAndShowMessage(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public List<String> splitStringToList(String inputStr) {
        return Arrays.stream(inputStr.split(",")).toList();
    }

    public boolean isCheckStringLength(List<String> strList, int length) {
        for(String str : strList) {
            if(str.length() > length) {
                return true;
            }
        }
        return false;
    }

    public boolean isNumericOrNonNegative(String cnt) {
        if(!(cnt.matches(NUM_REG) && Integer.parseInt(cnt) > 0)) {
            return true;
        }
        return false;
    }
}
