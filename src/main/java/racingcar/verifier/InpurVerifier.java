package racingcar.verifier;

import java.util.List;
import racingcar.system.ExceptionMessage;

public class InpurVerifier {
    public static void verifyName(String names) throws IllegalArgumentException {
        List<String> nameList = List.of(names.split(","));
        nameList
                .forEach(InpurVerifier::checkLength);
    }

    private static void checkLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE.getMessage());
        }
    }
}
