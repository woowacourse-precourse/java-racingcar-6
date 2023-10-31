package racingcar.utill;

import racingcar.string.ValidConstants;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidException {
    private static final String KOREAN_REGEX = "[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+";
    private static final Integer START_NUM_ZERO = 0;
    private static final Integer END_NUM_FIVE = 5;
    private static final String NUM_REGEX = ".*[0-9].*";
    private static final Integer ONLY_ONE_NAME = 0;
    private static final String KOREAN_ENGLISH_REGEX = ".*[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣].*";

    public static Boolean lessFIveLen(String str) {
        int len = str.length();

        if (len > START_NUM_ZERO && len <= END_NUM_FIVE) {
            return true;
        }

        throw new IllegalArgumentException(ValidConstants.MSG_INPUT_STRING_LENGTH_CHECK());
    }

    public static Boolean includeKorean(String str) {
        Pattern pattern = Pattern.compile(KOREAN_REGEX);
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            throw new IllegalArgumentException(ValidConstants.MSG_INCLUDE_KOREA_STRING());
        }

        return false;
    }

    public static void includeNum(String str) {
        Pattern pattern = Pattern.compile(NUM_REGEX);
        Matcher matcher = pattern.matcher(str);

        if (matcher.matches()) {
            throw new IllegalArgumentException(ValidConstants.MSG_INCLUDE_NUM());
        }
    }

    public static Boolean blankCheck(String str) {
        if (!str.equals("")) {
            return true;
        }
        throw new IllegalArgumentException(ValidConstants.MSG_BLANK_STRING());
    }

    public static void negative(String inputStr) {
        Integer inputNum = Integer.valueOf(inputStr);
        if (inputNum < 0) {
            throw new IllegalArgumentException(ValidConstants.MSG_NOT_POSITIVE_NUM());
        }
    }

    public static void includeString(String inputStr) {
        String regex = KOREAN_ENGLISH_REGEX;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches()) {
            throw new IllegalArgumentException(ValidConstants.MSG_INCLUDE_STRING());
        }
    }

    public static void includeSpecialString(String inputStr) {
        String regex = ".*[!@#$%^&*().?\":{}|<>].*"; // 특수 문자가 포함되어 있는지 확인하는 정규 표현식

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches()) {
            throw new IllegalArgumentException(ValidConstants.MSG_INCLUDE_SPECIAL_STRING());
        }
    }

    public static void includeBlank(String inputStr) {
        if (inputStr.contains(" ")) {
            throw new IllegalArgumentException(ValidConstants.MSG_INCLUDE_BLANK_STRING());
        }
    }

    public static void zeroNum(String inputStr) {
        Integer inputNum = Integer.valueOf(inputStr);

        if (inputNum == 0) {
            throw new IllegalArgumentException(ValidConstants.MSG_ZERO_NUM());
        }
    }

    public static boolean commaNextBlank(String inputStr) {
        int length = inputStr.length();

        if (inputStr.charAt(length - 1) != ',') {
            return true;
        }

        throw new IllegalArgumentException(ValidConstants.MSG_COMMA_NEXT_BLANK());
    }

    /**
     * 문자열은 , 기준으로 split 한후 각각의 문자열의 길이가 5이하인가.
     *
     * @param nameLine
     * @return
     */
    public static boolean NameOfEachFIveLessString(String nameLine) {
        String[] nameArr = Utill.makeArrFromString(nameLine, ",");
        List<String> nameList = Utill.makeListFromArr(nameArr);

        for (String name : nameList) {
            lessFIveLen(name);
        }

        return true;
    }

    public static boolean onlyOneNameOfRaceCar(String nameLine) {
        String[] nameArr = Utill.makeArrFromString(nameLine, ",");
        List<String> nameList = Utill.makeListFromArr(nameArr);
        Integer sizeNameList = nameList.size();

        if (Utill.isSameNum(sizeNameList, ONLY_ONE_NAME)) {
            throw new IllegalArgumentException(ValidConstants.MSG_COUNT_CAR_NAME_ONE());
        }

        return true;
    }
}
