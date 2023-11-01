package racingcar.vailidation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Vailidator {
    public static void checkDuplicate(List<String> carNames){
        Set<String> uniqueCarNames = new HashSet<>(carNames);
        if (carNames.size() != uniqueCarNames.size()) {
            throw new IllegalArgumentException("자동차 이름 중복.");
        }
    }
}
