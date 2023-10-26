package racingcar.domain;

public class Name {
    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("이름은 1~5 글자여야 합니다.");
        }
    }

    public void printName() {
        System.out.println(name);
    }
}
