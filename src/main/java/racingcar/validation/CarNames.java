package racingcar.validation;

import java.util.Arrays;
import java.util.List;

public class CarNames {
    List<String> splitNames(String in) {
        return Arrays.asList(in.split(",", -1));
    }

    void checkBlankInput(String in) throws IllegalArgumentException {
        List<String> names = splitNames(in);
        names.stream().forEach(name -> {
            if (isBlankString(name)) {
                throw new IllegalArgumentException();
            }
        });
    }

    boolean isBlankString(String in) {
        return in.trim().isEmpty();
    }
}
