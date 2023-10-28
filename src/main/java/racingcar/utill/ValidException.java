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


    /**
     * 양수 입력 검사.
     *
     * @param inputStr
     */
    public static void isValidPositiveCheck(String inputStr) {
        Integer inputNum = Integer.valueOf(inputStr);
        if (inputNum < 0) {
            throw new IllegalArgumentException(ValidConstants.MSG_NOT_POSITIVE_NUM());
        }
    }


    /**
     * 입력된 문자열에 한글, 영어가 포함되어있는가.
     *
     * @param inputStr
     */
    public static void isValidIncludeString(String inputStr) {
        String regex = ".*[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣].*"; // 영어와 한글이 포함되어 있는지 확인하는 정규 표현식

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches()) {
            throw new IllegalArgumentException(ValidConstants.MSG_INCLUDE_STRING());
        }
    }

    /**
     * 특수문자 포함 검사
     *
     * @param inputStr
     */
    public static void isValidIncludeSpecialString(String inputStr) {
        String regex = ".*[!@#$%^&*(),.?\":{}|<>].*"; // 특수 문자가 포함되어 있는지 확인하는 정규 표현식

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches()) {
            throw new IllegalArgumentException(ValidConstants.MSG_INCLUDE_SPECIAL_STRING());
        }
    }

    /**
     * 입력문자에 공백이 포함되어있는가.
     *
     * @param inputStr
     */
    public static void isValidIncludeBlank(String inputStr) {
        if (inputStr.contains(" ")) {
            throw new IllegalArgumentException(ValidConstants.MSG_INCLUDE_BLANK_STRING());
        }
    }

    /**
     * 0 입력 확인
     *
     * @param inputStr
     */
    public static void isValidZeroCheck(String inputStr) {
        Integer inputNum = Integer.valueOf(inputStr);
        if (inputNum == 0) {
            throw new IllegalArgumentException(ValidConstants.MSG_ZERO_NUM());
        }
    }
}
