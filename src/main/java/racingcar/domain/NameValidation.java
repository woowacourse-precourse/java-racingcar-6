package racingcar.domain;

import racingcar.utils.Util;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static racingcar.utils.Constants.*;

public class NameValidation {

    private final String NAMES;
    public final List<String> NAME_LIST;

    public NameValidation(String names) {
        this.NAMES = names;
        this.NAME_LIST = Util.toList(NAMES);
        isCorrectPattern();
        isCorrectLength();
        isDuplicate();
    }

    public void isCorrectPattern() {
        // 오직 하나의 문자만 입력되거나, 한 개 이상일 경우 이름과 이름 사이에 쉼표(,)로 구분되어야 한다.
        // 쉼표는 오직 하나만 사용되며, 이름과 이름 사이 외의 다른 위치에는 허용되지 않는다.
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
