package racingcar.domain;

public class Name {
    private final int MAX_LENGTH = 5;

    private final String name;

    public Name(String name){
        validate(name);
        this.name = name;
    }

    private void validate(String name){
        validateLength(name);
    }

    private void validateLength(String name){
        if (name.length() > MAX_LENGTH){
            throw new IllegalArgumentException();
        }
    }
}
