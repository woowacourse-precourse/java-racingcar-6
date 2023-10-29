package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class UserInput {


    public String readCarNames() {
        String names = Console.readLine();
        validateCarNames(names);
        return names;
    }


    public int readGameCount() {
        String gameCount = Console.readLine();
        validateGameCount(gameCount);
        return Integer.parseInt(gameCount);
    }


    //2) 사용자 입력에 대한 예외처리
    private void validateCarNames(String carName) throws IllegalArgumentException {
        String[] names = carName.split(",");
        //1) 각 이름 길이 5초과 시 예외
        validateCarNamesLength(names);
        //2) 각 이름에 " " 공백 포함 시 예외
        validateCarNamesBlank(names);
        //3) 이름 중복도 안됨
        validateCarNamesDuplicate(names);
    }

    // -이름 중복될 경우 - abc, ab,
    private void validateCarNamesDuplicate(String[] names) {
        //3) 이름이 중복될 경우 예외
        Map<String, Integer> map = new HashMap<>();

        for (String x : names) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                throw new IllegalArgumentException("경주할 자동차 이름은 중복되면 안됩니다.");
            }
        }
    }

    //validate 메소드 분리 - 길이
    private void validateCarNamesLength(String[] names) {
        //1) 각 이름 길이 5초과 시 예외
        for (String x : names) {
            if (x.length() > 5) {
                throw new IllegalArgumentException("경주할 자동차 이름의 길이는 5이하여야 합니다.");
            }
        }
    }

    //- 공백 포함 시
    private void validateCarNamesBlank(String[] names) {
        //2) 각 이름에 " " 공백 포함 시 예외
        for (String x : names) {
            if (x.contains(" ")) {
                throw new IllegalArgumentException("경주할 자동차 이름에 공백이 포함되면 안됩니다.");
            }
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