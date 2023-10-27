package racingcar.verifier;

import java.util.List;
import racingcar.system.ExceptionMessage;
import racingcar.system.SystemConstant;

public class InputVerifier {
    public static void verifyName(String names) throws IllegalArgumentException {
        InputVerifier.checkEmpty(names);
        List<String> nameList = List.of(names.split(","));
        nameList.forEach(InputVerifier::checkLength);
        nameList.forEach(InputVerifier::checkNull);
        checkDistinct(nameList);
    }

    public static void verifyTry(String tryReamain) throws IllegalArgumentException {
        checkEmpty(tryReamain);
        checkNumeric(tryReamain);
        checkNonPositive(tryReamain);
    }

    private static void checkLength(String name) {
        if (name.length() > SystemConstant.MAX_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE.getMessage());
        }
    }

    private static void checkNull(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NULL.getMessage());
        }
    }

    private static void checkDistinct(List<String> nameList) {
        if (nameList.stream()
                .distinct()
                .count() != nameList.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DISTINCT.getMessage());
        }
    }

    private static void checkNumeric(String tryRemain) {
        try {
            Integer.parseInt(tryRemain);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.TRY_NUMERAL.getMessage());
        }
    }

    private static void checkNonPositive(String tryRemain) {
        if (Integer.parseInt(tryRemain) < SystemConstant.POSITIVE_NUMBER.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.TRY_POSITIVE.getMessage());
        }
    }

    private static void checkEmpty(String string) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.IS_TOTALLY_NULL.getMessage());
        }
    }
}
