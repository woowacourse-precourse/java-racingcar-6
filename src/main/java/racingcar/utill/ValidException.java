package racingcar.utill;

import racingcar.string.ValidConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidException {
    // TODO: 10/27/23 이름은 5자 이하 검사.
    public static void isValidFIveLessString(String str) {

    }

    /**
     * 한글 포함 검사
     *
     * @param str "one, two, three"
     * @return
     */
    public static Boolean isValidIncludeKorean(String str) {
        Pattern pattern = Pattern.compile("[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+");
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            throw new IllegalArgumentException(ValidConstants.MSG_INCLUDE_KOREA_STRING());
        }
        return false;
    }

    // TODO: 10/27/23 숫자을 포함하는가 검사
    public static void isValidIncludeNum() {

    }

    /**
     * 공백 입력 검사
     *
     * @param str
     * @return
     */
    public static Boolean isValidBlankCheck(String str) {
        if (!str.equals("")) {
            return true;
        }
        throw new IllegalArgumentException(ValidConstants.MSG_BLANK_STRING());
    }

    // TODO: 10/27/23 양수 입력 검사
    public static void isValidPositiveCheck() {

    }

    // TODO: 10/27/23 문자열 포함 검사
    public static void isValidIncludeString() {

    }

    // TODO: 10/27/23 특수문자 포함 검사
    public static void isValidIncludeSpecialString() {

    }
}
