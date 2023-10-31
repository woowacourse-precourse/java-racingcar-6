package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    public String askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        validateInputFormat(carNames);
        validateNotDuplicated(carNames);
        return carNames;
    }

    public int askTryCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String tryCount = Console.readLine();
        validateInputIsNumeric(tryCount);
        validateInputInRange(tryCount);
        return Integer.parseInt(tryCount);
    }

    private void validateInputFormat(String input) {
        Pattern pattern = Pattern.compile(Constant.CAR_NAMES_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("자동차 이름은 1~5자 이내의 영어 또는 한글만 가능합니다. 쉼표(,)로 구분하여 두 대 이상 입력해주세요.");
        }
    }

    private void validateNotDuplicated(String carNames) {
        List<String> names = List.of(carNames.split(Constant.CAR_NAMES_DELIMITER));
        if (names.stream().distinct().count() != names.size()) {
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