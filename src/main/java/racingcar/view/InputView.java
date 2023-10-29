package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class InputView {

    public List<String> inputStringSplitBy(String delimiter) {
        String input = Console.readLine();
        return splitBy(input, delimiter);
    }

    public Integer inputDigit() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("잘못된 숫자 입력입니다" + input);
        }
    }


    private List<String> splitBy(String input, String delimiter) {
        String[] splitInput = input.split(delimiter);

        List<String> stringList = List.of(splitInput);
        checkString(stringList);

        return stringList;
    }

    private void checkString(List<String> stringList) {
        checkForEmptyString(stringList);
        checkForDuplicateStrings(stringList);
    }


    private void checkForEmptyString(List<String> stringList) {
        if (stringList.contains("")) {
            throw new IllegalArgumentException("빈 문자열이 포함되어 있습니다");
        }
    }

    private void checkForDuplicateStrings(List<String> stringList) {
        Set<String> stringSet = new HashSet<>(stringList);

        if (stringList.size() != stringSet.size()) {
            throw new IllegalArgumentException("중복되는 문자열이 포함되어 있습니다");
        }
    }


}
