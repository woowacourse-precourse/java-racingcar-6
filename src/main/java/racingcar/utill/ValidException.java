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
    private static final Integer ONLY_ONE_NAME = 1;
    private static final String KOREAN_ENGLISH_REGEX = ".*[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣].*";
    private static final String SPECIAL_CHARACTER_REGEX = ".*[!@#$%^&*().?\":{}|<>].*";
    private static final String NOTING_STRING = "";

    public static Boolean lessFIveLen(String strLine) {
        int len = strLine.length();

        if (len > START_NUM_ZERO && len <= END_NUM_FIVE) {
            return true;
        }

        throw new IllegalArgumentException(ValidConstants.MSG_INPUT_STRING_LENGTH_CHECK());
    }

    public static Boolean includeKorean(String strLine) {
        Pattern pattern = Pattern.compile(KOREAN_REGEX);
        Matcher matcher = pattern.matcher(strLine);

        if (matcher.find()) {
            throw new IllegalArgumentException(ValidConstants.MSG_INCLUDE_KOREA_STRING());
        }

        return false;
    }

    public static void includeNum(String strLine) {
        Pattern pattern = Pattern.compile(NUM_REGEX);
        Matcher matcher = pattern.matcher(strLine);

        if (matcher.matches()) {
            throw new IllegalArgumentException(ValidConstants.MSG_INCLUDE_NUM());
        }
    }

    public static Boolean blankCheck(String strLine) {
        if (!strLine.equals(NOTING_STRING)) {
            return true;
        }
        throw new IllegalArgumentException(ValidConstants.MSG_BLANK_STRING());
    }

    public static void negative(String strLine) {
        Integer inputNum = Integer.valueOf(strLine);
        if (inputNum < 0) {
            throw new IllegalArgumentException(ValidConstants.MSG_NOT_POSITIVE_NUM());
        }
    }

    public static void includeString(String strLine) {
        Pattern pattern = Pattern.compile(KOREAN_ENGLISH_REGEX);
        Matcher matcher = pattern.matcher(strLine);

        if (matcher.matches()) {
            throw new IllegalArgumentException(ValidConstants.MSG_INCLUDE_STRING());
        }
    }

    public static void includeSpecialString(String strLine) {
        Pattern pattern = Pattern.compile(SPECIAL_CHARACTER_REGEX);
        Matcher matcher = pattern.matcher(strLine);

        if (matcher.matches()) {
            throw new IllegalArgumentException(ValidConstants.MSG_INCLUDE_SPECIAL_STRING());
        }
    }

    public static void includeBlank(String strLine) {
        if (strLine.contains(" ")) {
            throw new IllegalArgumentException(ValidConstants.MSG_INCLUDE_BLANK_STRING());
        }
    }

    public static void zeroNum(String strLine) {
        Integer inputNum = Integer.valueOf(strLine);

        if (inputNum == 0) {
            throw new IllegalArgumentException(ValidConstants.MSG_ZERO_NUM());
        }
    }

    public static boolean commaNextBlank(String strLine) {
        int length = strLine.length();

        if (strLine.charAt(length - 1) != ',') {
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
    public static boolean nameOfEachFIveLessString(String nameLine) {
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
