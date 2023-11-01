package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    public String askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        validateCarNames(carNames);
        return carNames;
    }

    public int askTryCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String tryCount = Console.readLine();
        validateTryCount(tryCount);
        return Integer.parseInt(tryCount);
    }

    private void validateCarNames(String carNames) {
        List<String> nameList = List.of(carNames.split(Constant.CAR_NAMES_DELIMITER));
        validateNotBlank(carNames);
        validateNotEndWithDelimiter(carNames);
        validateMinimumCount(nameList);
        nameList.forEach(this::validateEachName);
        validateNotDuplicated(nameList);
    }

    private void validateTryCount(String tryCount) {
        validateNotBlank(tryCount);
        validateInputIsNumeric(tryCount);
        validateInputInRange(tryCount);
    }

    private void validateNotBlank(String input) {
        if (input == null || input.isBlank() || containsWhitespace(input)) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }

    private boolean containsWhitespace(String input) {
        Pattern pattern = Pattern.compile(Constant.WHITESPACE_PATTERN);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    private void validateNotEndWithDelimiter(String carNames) {
        if (carNames.endsWith(Constant.CAR_NAMES_DELIMITER)) {
            throw new IllegalArgumentException("자동차 이름은 구분자(,)로 끝날 수 없습니다.");
        }
    }

    private void validateEachName(String name) {
        validateNotBlank(name);
        validateLength(name);
    }

    private void validateMinimumCount(List<String> inputList) {
        if (inputList.size() < Constant.MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
        }
    }

    private void validateLength(String input) {
        if (input.length() < Constant.MINIMUM_CAR_NAME_LENGTH || input.length() > Constant.MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1~5자 이내여야 합니다.");
        }
    }

    private void validateNotDuplicated(List<String> inputList) {
        if (inputList.stream().distinct().count() != inputList.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    private void validateInputIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수로 숫자를 입력해주세요.");
        }
    }

    private void validateInputInRange(String input) {
        int tryCount = Integer.parseInt(input);
        if (tryCount < Constant.MINIMUM_TRY_COUNT || tryCount > Constant.MAXIMUM_TRY_COUNT) {
            throw new IllegalArgumentException("시도할 횟수는 1회 이상이어야 합니다.");
        }
    }
}