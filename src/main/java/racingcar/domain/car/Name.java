package racingcar.domain.car;

public class Name {

    private String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateBlank(name);
        validateName(name);
    }

    private void validateBlank(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름은 빈값이면 안됩니다");
        }
    }

    private void validateName(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하여야합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
