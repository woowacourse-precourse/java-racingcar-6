package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExceptionChecker {
    public List<String> containsComma(String strCarName) {
        List<String> strCarNameList = new ArrayList<String>(Arrays.asList(strCarName.split(",")));
        return strCarNameList;
    }

    public void nameLongerThanFiveWithComma(String strCarName) throws IllegalArgumentException {
        List<String> strCarNameList = containsComma(strCarName);
        for (String carName : strCarNameList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("입력한 이름이 5자를 넘겼으므로 프로그램을 종료합니다.");
            }
        }
    }

    public void nameLongerThanFiveWithoutComma(String strCarName) throws IllegalArgumentException {
        if (strCarName.length() > 5) {
            throw new IllegalArgumentException("입력한 이름이 5자를 넘겼으므로 프로그램을 종료합니다.");
        }
    }

    public void isNameDuplicated(String strCarName) throws IllegalArgumentException {
        List<String> strCarNameList = containsComma(strCarName);
        Set<String> strCarNameListSet = new HashSet<>(strCarNameList);
        if (strCarNameList.size() != strCarNameListSet.size()) {
            throw new IllegalArgumentException("입력한 이름이 중복되었으므로 프로그램을 종료합니다.");
        }
    }

    public void wrongInputCarName(String strCarName) {
        if (strCarName.contains(",")) {
            nameLongerThanFiveWithComma(strCarName);
            isNameDuplicated(strCarName);
        } else if (!strCarName.contains(",")) {
            nameLongerThanFiveWithoutComma(strCarName);
        }
    }


    public void isNotInteger(String strTries) throws IllegalArgumentException {
        try {
            Integer.parseInt(strTries);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("입력한 횟수가 정수가 아니므로 프로그램을 종료합니다.");
        }
    }

    public void lessThenZero(String strTries) throws IllegalArgumentException {
        if (Integer.parseInt(strTries) < 0) {
            throw new IllegalArgumentException("입력한 횟수가 음수이므로 프로그램을 종료합니다.");
        }
    }

    public void wrongInputTries(String strTries) {
        isNotInteger(strTries);
        lessThenZero(strTries);
    }
}
