package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import racingcar.utils.constant.Constant;

public class StringUtils {
    public List<String> split(String s) {
        return Arrays.asList(s.split(Constant.SPLIT_DELIMITER));
    }

    public int convertStringToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
