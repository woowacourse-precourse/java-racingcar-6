package racingcar;

import racingcar.view.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    // 공백 제거
    public static String trim(String carNames) {
        Pattern trimPattern = Pattern.compile(Constants.SPACE_REGEX.getValue());
        Matcher matcher = trimPattern.matcher(carNames);
        return matcher.replaceAll("");
    }
}
