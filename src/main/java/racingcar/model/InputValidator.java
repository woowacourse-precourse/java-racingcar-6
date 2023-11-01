package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final int MAX_LENGTH = 5;
    private static final Pattern NUMBER = Pattern.compile("^[0-9]+$");
    private static final Pattern BLANK = Pattern.compile("^\\s*$");

    public static void validateNumber(String userInputTryNumber) {
        if (!isNumber(userInputTryNumber)) {
            throw new IllegalArgumentException("양의 정수를 입력해주세요.");
        }
    }

    public static void validateDuplication(List<String> carNameList) {
        if (isDuplicated(carNameList)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    public static void validateEmptyName(List<String> carNameList) {
        if (isContainEmptyOrBlank(carNameList)) {
            throw new IllegalArgumentException("공백은 이름이 될수 없습니다.");
        }
    }

    public static void validateNameLength(List<String> carNameList) {
        if (isContainOverMaxLength(carNameList)) {
            throw new IllegalArgumentException("이름은 1자 이상, 5자 이하여야 합니다.");
        }
    }

    private static boolean isNumber(String userInputTryNumber) {
        Matcher matcher = NUMBER.matcher(userInputTryNumber);
        return matcher.matches();
    }

    private static boolean isDuplicated(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        return carNameSet.size() != carNameList.size();
    }

    private static boolean isContainEmptyOrBlank(List<String> carNameList) {
        return carNameList.stream()
                .anyMatch(carName -> carName.isEmpty() || isBlank(carName));
    }

    private static boolean isBlank(String carName) {
        Matcher matcher = BLANK.matcher(carName);
        return matcher.matches();
    }

    private static boolean isContainOverMaxLength(List<String> carNameList) {
        return carNameList.stream()
                .anyMatch(name -> name.length() > MAX_LENGTH);
    }
}
