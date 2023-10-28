package racingcar.domain;

public class Name {

    private String name;

    public Name(String name) {

        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {

        if(name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}
