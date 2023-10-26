package racingcar.domain;

public class Name {
    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름 길이는 최대 5자입니다.");
        }
    }

    public void printName() {
        System.out.println(name);
    }
}
