package racingcar.domain;

public class Name {

    private static final int MAX_NAMING_LENGTH = 5;
    private static final String NAMING_LENGTH_ERROR_MESSAGE = "자동차 이름은 " + MAX_NAMING_LENGTH + "글자를 넘길 수 없습니다.";
    private String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAMING_LENGTH) {
            throw new IllegalArgumentException(NAMING_LENGTH_ERROR_MESSAGE);
        }
    }

    public String getLawName() {
        return name;
    }
}
