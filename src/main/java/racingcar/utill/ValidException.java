package racingcar.utill;

import racingcar.string.ValidConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidException {
    /**
     * 이름은 5자 이하 검사.
     *
     * @param str
     */
    public static Boolean isValidFIveLessString(String str) {
        int length = str.length();
        if (length > 0 && length <= 5) {
            return true;
        }
        throw new IllegalArgumentException(ValidConstants.MSG_INPUT_STRING_LENGTH_CHECK());
    }

    // TODO: 10/28/23 문자열 이름, 다음에는 문자가 나와야 한다. "sue,woo," 금지. isValidCommaNextBlankCheck


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

    /**
     * 숫자를 포함하는 여부 검사.
     *
     * @param inputStr
     */
    public static void isValidIncludeNum(String inputStr) {
        String regex = ".*[0-9].*"; // 숫자가 포함되어 있는지 확인하는 정규 표현식

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches()) {
            throw new IllegalArgumentException(ValidConstants.MSG_INCLUDE_NUM());
        }
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
        String regex = ".*[!@#$%^&*().?\":{}|<>].*"; // 특수 문자가 포함되어 있는지 확인하는 정규 표현식

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

    /**
     * 문자열 이름 , 다음에는 문자가 나와야한다.
     * "woo," , 다음에 문자열이 입력되는가.
     *
     * @param inputStr
     * @return
     */
    public static boolean isValidCommaNextBlankCheck(String inputStr) {
        int length = inputStr.length();
        if (inputStr.charAt(length - 1) != ',') {
            return true;
        }
        throw new IllegalArgumentException(ValidConstants.MSG_COMMA_NEXT_BLANK());
    }

    /**
     * 자동차의 각각의 이름이 5글자 이하인가 확인
     *
     * @param inputStr
     * @return
     */
    public static boolean isValidCarEachNameFIveLessString(String inputStr) {
        List<String> nameEachOfList = Arrays.stream(inputStr.split(",")).toList();
        System.out.println("nameEachOfList = " + nameEachOfList);
        for (String name : nameEachOfList) {
            isValidFIveLessString(name);
        }
        return true;
    }

    /**
     * 자동차의 이름을 입력할때 자동차 하나만 입력하면 안된다.
     *
     * @param inputStr
     * @return
     */
    public static boolean isValidOneNameOfRaceCarCheck(String inputStr) {
        List<String> nameOfCarList = Arrays.stream(inputStr.split(",")).toList();
        Integer sizeNameOfCarList = nameOfCarList.size();
        if (sizeNameOfCarList <= 1) {
            throw new IllegalArgumentException(ValidConstants.MSG_COUNT_CAR_NAME_ONE());
        }
        return true;
    }
}
