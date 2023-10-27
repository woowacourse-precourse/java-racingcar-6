package racingcar.verifier;

import java.util.List;
import racingcar.system.ExceptionMessage;
import racingcar.system.SystemConstant;

public class InputVerifier {
    public static void verifyName(String names) throws IllegalArgumentException {
        List<String> nameList = List.of(names.split(","));
        nameList.forEach(InputVerifier::checkLength);
        nameList.forEach(InputVerifier::checkNull);
    }

    private static void checkLength(String name) {
        if (name.length() > SystemConstant.MAX_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE.getMessage());
        }
    }

    private static void checkNull(String name) {

    }
}
