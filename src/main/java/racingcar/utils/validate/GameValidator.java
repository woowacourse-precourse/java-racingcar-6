package racingcar.utils.validate;

import static racingcar.constant.ExceptionMessage.DUPLICATED_NAME;
import static racingcar.constant.ExceptionMessage.ROUND_MUST_BE_POSITIVE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.utils.dto.Names;

public class GameValidator {

    public static void validateRoundNum(int roundNum) {
        if (checkNumIsZeroOrNegative(roundNum)) {
            throw new IllegalArgumentException(ROUND_MUST_BE_POSITIVE.getMessage());
        }
    }

    public static void validateDuplicatedName(String[] nameArr) {
        Set<String> nameBag = new HashSet<>(List.of(nameArr));
        if (nameBag.size() != nameArr.length) {
            throw new IllegalArgumentException(DUPLICATED_NAME.getMessage());
        }
    }

    private static boolean checkNumIsZeroOrNegative(int num) {
        return num <= 0;
    }
}