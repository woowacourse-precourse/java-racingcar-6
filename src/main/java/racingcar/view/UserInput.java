package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class UserInput {
    static String userInputCarName;
    static int gameCount;

    public UserInput() {
    }


    public static String getUserInputCarName() {
        return userInputCarName;
    }

    public static int getGameCount() {
        return gameCount;
    }


    public void readCarNames() {
        String names = Console.readLine();
        validateCarNames(names);
        userInputCarName = names;
    }


    public void readGameCount() {
        String count = Console.readLine();
        validateGameCount(count);
        gameCount = Integer.parseInt(count);
    }


    //2) 사용자 입력에 대한 예외처리
    private void validateCarNames(String carName) throws IllegalArgumentException {
        String[] names = carName.split(",");
        //1) 각 이름 길이 5초과 시 예외
        validateLength(names);
        //2) 각 이름에 " " 공백 포함 시 예외
        validateBlank(names);
        //3) 이름 중복도 안됨
        validateDuplicate(names);
    }

    // -이름 중복될 경우 - abc, ab,
    private void validateDuplicate(String[] names) {
        //3) 이름이 중복될 경우 예외
        Map<String, Integer> map = new HashMap<>();

        for (String x : names) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) > 1)
                throw new IllegalArgumentException("경주할 자동차 이름은 중복되면 안됩니다.");
        }
    }

    //validate 메소드 분리 - 길이
    private void validateLength(String[] names) {
        //1) 각 이름 길이 5초과 시 예외
        for (String x : names) {
            if (x.length() > 5) {
                throw new IllegalArgumentException("경주할 자동차 이름의 길이는 5이하여야 합니다.");
            }
        }
    }

    //- 공백 포함 시
    private void validateBlank(String[] names) {
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
        validateNotNumber(gameCount);
        //범위 벗어난 입력
        validateOutOfRange(gameCount);
    }

    private void validateNotNumber(String gameCount) throws IllegalArgumentException {
        for (char ch : gameCount.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("게임 실행 횟수는 숫자만 입력해야 합니다.");
            }
        }
    }

    private void validateOutOfRange(String gameCount) throws IllegalArgumentException {
        int num = Integer.parseInt(gameCount);
        if (num <= 0) {
            throw new IllegalArgumentException("게임 실행 횟수는 양수만 입력해야 합니다.");
        }
    }

}