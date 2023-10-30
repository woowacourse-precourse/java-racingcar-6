package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class UserInput {
    private static final String CAR_NAMES_DELIMETER = ",";

    public List<String> readCarNames() {
        String names = Console.readLine();
        validateInputComma(names);

        List<String> nameList = parseCarNamesToList(names);
        validateCarNamesList(nameList);

        return nameList;
    }

    public int readGameCount() {
        String gameCount = Console.readLine();
        validateGameCount(gameCount);
        return Integer.parseInt(gameCount);
    }

    private List<String> parseCarNamesToList(String names) {
        return Arrays.stream(names.split(CAR_NAMES_DELIMETER)).toList();
    }

    /**
     * 처음 String으로 입력된 Input 상태에서 ,(쉼표) 위치에 따른 예외처리
     */
    private void validateInputComma(String carName) throws IllegalArgumentException {
        validateFirstComma(carName);

        validateMiddleCommaRepeat(carName);

        validateLastComma(carName);
    }

    private void validateFirstComma(String names) throws IllegalArgumentException {
        if (names.charAt(0) == ',') {
            throw new IllegalArgumentException("자동차 이름 입력이 (,) 쉼표로 시작되면 안됩니다.");
        }
    }

    private void validateMiddleCommaRepeat(String names) throws IllegalArgumentException {
        String commaRepeat = ",,";
        if (names.contains(commaRepeat)) {
            throw new IllegalArgumentException("자동차 이름에는 (,) 연속된 쉼표를 입력해서는 안됩니다.");
        }
    }

    private void validateLastComma(String names) throws IllegalArgumentException {
        int len = names.length();
        if (names.charAt(len - 1) == ',') {
            throw new IllegalArgumentException("자동차 이름 입력 끝에는 (,) 쉼표가 있으면 안됩니다.");
        }
    }

    /**
     * List<String> 으로 쪼갠 각각의 Car 이름형태에 대한 예외처리
     */
    private void validateCarNamesList(List<String> names) throws IllegalArgumentException {
        validateCarNamesLength(names);

        validateCarNamesBlank(names);

        validateCarNamesDuplicate(names);
    }

    private void validateCarNamesLength(List<String> names) {
        if (names.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("경주할 자동차 이름의 길이는 5 이하여야 합니다.");
        }
    }

    private void validateCarNamesBlank(List<String> names) {
        if (names.stream().anyMatch(name -> name.contains(" "))) {
            throw new IllegalArgumentException("경주할 자동차 이름에 공백이 포함되면 안됩니다.");
        }
    }

    private void validateCarNamesDuplicate(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("경주할 자동차 이름은 중복되면 안됩니다.");
        }
    }

    /**
     * gameCount 입력에 대한 예외처리
     */
    private void validateGameCount(String gameCount) throws IllegalArgumentException {
        //숫자가 아닌 경우
        validateGameCountNotNumber(gameCount);
        //범위 벗어난 입력
        validateGameCountOutOfRange(gameCount);
        //0으로 시작하는 입력
        validateGameCountStartWithZero(gameCount);
    }

    private void validateGameCountNotNumber(String gameCount) throws IllegalArgumentException {
        try {
            Integer.parseInt(gameCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("게임 실행 횟수는 숫자만 입력해야 합니다.");
        }
    }

    private void validateGameCountOutOfRange(String gameCount) throws IllegalArgumentException {
        int num = Integer.parseInt(gameCount);
        if (num <= 0) {
            throw new IllegalArgumentException("게임 실행 횟수는 양수만 입력해야 합니다.");
        }
    }

    private void validateGameCountStartWithZero(String gameCount) throws IllegalArgumentException {
        if (gameCount.startsWith("0")) {
            throw new IllegalArgumentException("게임 실행 횟수 입력은 0으로 시작하면 안됩니다.");
        }
    }

}