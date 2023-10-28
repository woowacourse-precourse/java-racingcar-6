package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public static void validateCarNames(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }

        List<String> carNameList = Arrays.asList(carNames.split(","));
        Set<String> uniqueCarNames = new HashSet<>(carNameList);

        if (carNameList.size() != uniqueCarNames.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
        }

        if (carNameList.stream().anyMatch(carName -> carName.length() > 5)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public static void validateRound(String round) {
        if (round == null || round.isEmpty()) {
            throw new IllegalArgumentException("시도할 회수를 입력해주세요.");
        }

        if (!round.matches("[0-9]+")) {
            throw new IllegalArgumentException("시도할 회수는 숫자만 가능합니다.");
        }
    }
}
