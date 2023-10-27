package racingcar.verifier;

import java.util.List;
import racingcar.system.ExceptionMessage;
import racingcar.system.SystemConstant;

public class InpurVerifier {
    public static void verifyName(String names) throws IllegalArgumentException {
        List<String> nameList = List.of(names.split(","));
        nameList
                .forEach(InpurVerifier::checkLength);
    }

    private static void checkLength(String name) {
        if (name.length() > SystemConstant.MAX_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE.getMessage());
        }
    }
}
