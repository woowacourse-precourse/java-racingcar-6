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
    }

    public static void verifyTry(String tryReamain) throws IllegalArgumentException {
        InputVerifier.checkEmpty(tryReamain);
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

    private static void checkEmpty(String string) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.IS_TOTALLY_NULL.getMessage());
        }
    }
}
