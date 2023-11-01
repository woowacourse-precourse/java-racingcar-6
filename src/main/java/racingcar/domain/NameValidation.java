package racingcar.domain;

import static racingcar.utils.Constants.DUPLICATE_EXCEPTION;
import static racingcar.utils.Constants.INVALID_INPUT_EXCEPTION;
import static racingcar.utils.Constants.LENGTH_EXCEPTION;
import static racingcar.utils.Constants.NAME_VALIDATION_REGEX;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import racingcar.utils.Util;

public class NameValidation {

    private final String NAMES;
    public final List<String> NAME_LIST;

    public NameValidation(String names) {
        this.NAMES = names;
        this.NAME_LIST = Util.toArrayList(NAMES);
    }

    public void validation() {
        isCorrectPattern();
        isCorrectLength();
        isDuplicate();
    }

    public void isCorrectPattern() {
        Pattern correctPattern = Pattern.compile(NAME_VALIDATION_REGEX.getValue());
        if (!correctPattern.matcher(NAMES).matches()) {
            throw new IllegalArgumentException(INVALID_INPUT_EXCEPTION.getValue());
        }
    }

    public void isCorrectLength() {
        Stream<String> stream = NAME_LIST.stream();
        if (stream.anyMatch(name -> name.isEmpty() || name.length() > 5)) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION.getValue());
        }
    }

    public void isDuplicate() {
        if (Util.countDuplicate(NAME_LIST) != 0L) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION.getValue());
        }
    }

}
