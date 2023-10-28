package racingcar.domain.car;

import java.util.regex.Pattern;

public class Name {
    private static final String NAME_REGEX = "^[a-zA-Z가-힣]{1,5}$";
    private static final Pattern pattern = Pattern.compile(NAME_REGEX);
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    private void validate(String name) {
        if (isNotMatchValidNameCondition(name)) {
            throw new IllegalArgumentException("이름은 공백 없는 1~5자의 영어 또는 한글이어야 합니다.");
        }
    }

    private boolean isNotMatchValidNameCondition(String name) {
        return !pattern.matcher(name).matches();
    }
}
