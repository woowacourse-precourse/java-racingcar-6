package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Judgement {
    public static List<String> getNamesFromUser(String unCheckedCarNames) {
        return separateCarNames(unCheckedCarNames);
    }

    private static List<String> separateCarNames(String unCheckedCarNames) {
        List<String> carNames = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(unCheckedCarNames, ",");
        while (st.hasMoreTokens()) {
            String carName = st.nextToken();
            checkNameIsValid(carName);
            carNames.add(carName);
        }
        return carNames;
    }

    private static void checkNameIsValid(String carNames) {
        if (carNames.length() > 5) {
            throw new IllegalArgumentException("5글자를 초과한 이름은 입력할 수 없습니다.");
        }
    }

    public static int getPlayCountFromUser(String unParsedPlayCount) {
        checkPlayCount(unParsedPlayCount);
        return Integer.parseInt(unParsedPlayCount);
    }

    private static void checkPlayCount(String unParsedPlayCount) {
        int playCount = 0;
        try {
            playCount = Integer.parseInt(unParsedPlayCount);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해야합니다.");
        }
    }
}
