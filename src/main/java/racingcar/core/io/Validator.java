package racingcar.core.io;

import java.util.List;

public class Validator {
    public void valid(List<String> parsingList) {
        for (String name : parsingList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
