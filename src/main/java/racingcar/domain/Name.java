package racingcar.domain;

public class Name {
    private final static int NAME_LENGH_MIN = 1;
    private final static int NAME_LENGH_MAX = 5;
    private String name;

    private Name(String name) {
        validateRange(name);
        this.name = name;
    }

    public static Name create(String name) {
        return new Name(name);
    }

    public void validateRange(String name) {
        if (name.length() < NAME_LENGH_MIN || name.length() > NAME_LENGH_MAX) {
            throw new IllegalArgumentException("이름은 1~5글자 사이여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}