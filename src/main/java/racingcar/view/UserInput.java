package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class UserInput {
    private static final String CAR_NAMES_DELIMETER = ",";

    public List<String> readCarNames() {
        String names = Console.readLine();
        validateCarNames(names);
        return Arrays.stream(names.split(CAR_NAMES_DELIMETER)).toList();
    }

    public int readGameCount() {
        String gameCount = Console.readLine();
        validateGameCount(gameCount);
        return Integer.parseInt(gameCount);
    }


    //2) 사용자 입력에 대한 예외처리
    private void validateCarNames(String carName) throws IllegalArgumentException {
        List<String> names = Arrays.stream(carName.split(CAR_NAMES_DELIMETER)).toList();
        //1) 각 이름 길이 5초과 시 예외
        validateCarNamesLength(names);
        //2) 각 이름에 " " 공백 포함 시 예외
        validateCarNamesBlank(names);
        //3) 이름 중복도 안됨
        validateCarNamesDuplicate(names);
    }


    //validate 메소드 분리 - 길이
    private void validateCarNamesLength(List<String> names) {
        if (names.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("경주할 자동차 이름의 길이는 5 이하여야 합니다.");
        }
    }

    //- 공백 포함 시
    private void validateCarNamesBlank(List<String> names) {
        if (names.stream().anyMatch(name -> name.contains(" "))) {
            throw new IllegalArgumentException("경주할 자동차 이름에 공백이 포함되면 안됩니다.");
        }
    }

    // -이름 중복될 경우 - abc, ab,
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
    }

    private void validateGameCountNotNumber(String gameCount) throws IllegalArgumentException {
        for (char ch : gameCount.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("게임 실행 횟수는 숫자만 입력해야 합니다.");
            }
        }
    }

    private void validateGameCountOutOfRange(String gameCount) throws IllegalArgumentException {
        int num = Integer.parseInt(gameCount);
        if (num <= 0) {
            throw new IllegalArgumentException("게임 실행 횟수는 양수만 입력해야 합니다.");
        }
    }

}