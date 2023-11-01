package racingcar.common.exception;

import racingcar.common.constant.GuidePhrases;

import java.util.List;
import java.util.stream.Collectors;

public class CarNameDuplicationException {
    public static void isDuplication(List<String> carNames) {
        int beforeSize = carNames.size();
        List<String> newList =
                carNames.stream()
                        .distinct()
                        .collect(Collectors.toList());
        int afterRemoveDuplicationListSize = newList.size();
        if (beforeSize != afterRemoveDuplicationListSize) {
            throw new IllegalArgumentException(GuidePhrases.isDuplication);
        }
    }
}
