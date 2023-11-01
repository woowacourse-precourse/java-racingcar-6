package racingcar.util;

import java.util.HashSet;
import racingcar.view.InputView;

public class UserInput {
    static final int MIN_NAME_LENGTH = 1;
    static final int MAX_NAME_LENGTH = 5;

    public static String[] getCarNames() {
        String[] carNames = InputView.setUserInput().split(",");
        checkEmpty(carNames);
        checkNameLength(carNames);
        checkDuplicates(carNames);
        return carNames;
    }

    public static void checkEmpty(String[] nameList) {
        if (nameList.length == 0) {
            throw new IllegalArgumentException
                    (String.format("이름을 %d자 이상, %d자 이내로 입력해주세요.", MIN_NAME_LENGTH, MAX_NAME_LENGTH));
        }
    }

    public static void checkNameLength(String[] nameList) {
        for (String name : nameList) {
            if (name.length() < MIN_NAME_LENGTH) {
                throw new IllegalArgumentException(String.format("이름을 %d자 이상 입력해주세요.", MIN_NAME_LENGTH));
            }
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(String.format("이름을 %d자 이내로 입력해주세요.", MAX_NAME_LENGTH));
            }
        }
    }

    public static void checkDuplicates(String[] nameList) {
        HashSet<String> uniqueNames = new HashSet<>();
        for (String name : nameList) {
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException("이름을 중복되지 않게 입력해주세요.");
            }
        }
    }

    public static int getTotalRound() {
        String inputRaceCount = InputView.setRaceCount();
        int raceCount = checkInteger(inputRaceCount);
        checkPositiveInteger(raceCount);
        return raceCount;
    }

    public static int checkInteger(String inputRaceCount) {
        try {
            return Integer.parseInt(inputRaceCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    public static void checkPositiveInteger(int raceCount) {
        if (raceCount < 1) {
            throw new IllegalArgumentException("양의 정수만 입력해주세요.");
        }
    }
}
