package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

class Reader {
    private static final String NAME_DELIM = ",";
    private final Validator validator;

    Reader(Validator validator) {
        this.validator = validator;
    }

    List<String> readNames() {
        List<String> names = Arrays.stream(readLine().split(NAME_DELIM)).toList();
        validator.validateSize(names);
        validator.validateNamePattern(names);
        validator.validateDuplicate(names);
        return names;
    }

    private String readLine() {
        try {
            return Console.readLine();
        } catch (Exception ex) {
            throw new IllegalArgumentException();
        }
    }

    int readOneNumber() {
        try {
            int number = Integer.parseInt(readLine());
            validator.validateRaceCountRange(number);
            return number;
        } catch (Exception ex) {
            throw new IllegalArgumentException();
        }
    }
}
