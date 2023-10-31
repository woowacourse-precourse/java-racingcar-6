package racingcar.validation;

import java.util.List;
import racingcar.util.NameHandler;

public class CarNames {
    static final String BLANK_INPUT_EXCEPTION = "공백 입력입니다.";
    static final String NAME_LENGTH_EXCEPTION = "이름 길이가 5를 초과합니다.";
    static final String SAME_NAMES_EXCEPTION = "중복된 이름이 존재합니다.";

    public List<String> validateCarNames(String in) {
        List<String> names = NameHandler.splitNames(in);
        checkBlankInput(names);
        checkNameLength(names);
        checkSameNames(names);
        return names;
    }

    private void checkBlankInput(List<String> names) throws IllegalArgumentException {
        names.stream().forEach(name -> {
            if (isBlankName(name)) {
                throw new IllegalArgumentException(BLANK_INPUT_EXCEPTION);
            }
        });
    }

    private boolean isBlankName(String name) {
        return name.trim().isEmpty();
    }

    private void checkNameLength(List<String> names) throws IllegalArgumentException {
        names.stream().forEach(name -> {
            if (isLongName(name)) {
                throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION);
            }
        });
    }

    private boolean isLongName(String name) {
        return name.length() > 5;
    }

    private void checkSameNames(List<String> names) throws IllegalArgumentException {
        if (hasDuplicateNames(names)) {
            throw new IllegalArgumentException(SAME_NAMES_EXCEPTION);
        }
    }

    private boolean hasDuplicateNames(List<String> names) {
        return names.size() != names.stream().distinct().count();
    }
}
