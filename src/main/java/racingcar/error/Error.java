package racingcar.error;

import java.util.HashSet;
import java.util.List;

public class Error {
    //최대 int를 초과하지 않는 최대 길이 임의 설정
    private static final int MAX_INT_LENGTH = 9;
    private static final int MAX_STRING_LENGTH = 5;
    private static final String regex = "^\\d+$";

    public static void checkIllegalString(List<String> nameList) {
        boolean containLongerThan5 = nameList.stream().anyMatch(s -> s.length() > MAX_STRING_LENGTH);
        boolean containDuplicateString = new HashSet<>(nameList).size() != nameList.size();

        if (containLongerThan5) {
            throw new IllegalArgumentException("5자 이하의 이름만 가능합니다. ','으로 구분하여 입력해주세요.");
        }

        if (containDuplicateString) {
            throw new IllegalArgumentException("중복된 이름이 입력되었습니다. 다시 입력해주세요.");
        }
    }

    public static void checkIsNumber(String number) {
        boolean isAllDigit = number.matches(regex);

        if (!isAllDigit || number.isBlank()) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }

        if (number.length() > MAX_INT_LENGTH) {
            throw new IllegalArgumentException("10억 이하의 숫자만 입력해주세요.");
        }
    }
}
