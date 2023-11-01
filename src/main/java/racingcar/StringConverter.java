package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringConverter {
    private static final IllegalCheck illegalCheck = new IllegalCheck();
    private final String ERROR_MESSAGE = "잘못된 값이 입력되었습니다.";

    public int stringToInteger() {
        String inputLine = Console.readLine();
        if (!integerIllegalcheckfilter(inputLine).stream()
                .allMatch(filter -> filter.test(inputLine))) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return Integer.parseInt(inputLine);
    }

    public List<String> stringToCarNames(String separator) {
        String inputLine = Console.readLine();
        List<String> splittedNames = Arrays.stream(inputLine.split(separator)).toList();

        if (!namesIllegalcheckfilter(splittedNames, inputLine).stream()
                .allMatch(filter -> filter.test(inputLine))) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return splittedNames;
    }

    public List<Predicate<String>> integerIllegalcheckfilter(String inputLine) {
        List<Predicate<String>> filterList = new ArrayList<>();

        filterList.add((s) -> illegalCheck.blankCheck(inputLine));
        filterList.add((s) -> inputLine.chars()
                .allMatch(illegalCheck::availableConvertInteger));
        filterList.add((s) -> illegalCheck.integerRangeOverCheck(Long.parseLong(inputLine)));

        return filterList.stream().collect(Collectors.toUnmodifiableList());
    }

    public List<Predicate<String>> namesIllegalcheckfilter(List<String> splittedNames, String inputLine) {
        List<Predicate<String>> filterList = new ArrayList<>();

        filterList.add((s) -> illegalCheck.blankCheck(inputLine));
        filterList.add((s) -> splittedNames.stream()
                .allMatch(illegalCheck::stringLengthOverCheck));
        filterList.add((s) -> illegalCheck.duplicateNameCheck(splittedNames));

        return filterList.stream().collect(Collectors.toUnmodifiableList());
    }
}
