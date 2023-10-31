package racingcar.domain.car.property;

public class Name {
    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("이름은 1~5 글자여야 합니다.");
        }
    }

    public void print() {
        System.out.print(name);
    }

    public String getName() {
        return name;
    }
}
