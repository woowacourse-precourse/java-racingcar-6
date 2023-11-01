package racingcar;
import java.util.*;

public class Checker {
    public static void checkNameLength(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static void checkNameDuplication(List<String> carNames) {
        Set<String> nameSet = new HashSet<>(carNames);
        if (nameSet.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름에 중복이 있습니다.");
        }
    }

    public static int checkValidTurn(String turn) {
        try {
            int numberOfTurns = Integer.parseInt(turn);
            if (numberOfTurns <= 0) {
                throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
            }
            return numberOfTurns;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 값이 정수가 아닙니다.");
        }
    }
}
