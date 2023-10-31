package racingcar.domain;

public class Name {
    private final int MAX_LENGTH = 5;

    private final String name;

    public Name(String name){
        validate(name);
        this.name = name;
    }

    public String getName(){
        return name;
    }

    private void validate(String name){
        validateIsNotEmpty(name);
        validateLength(name);
    }

    private void validateLength(String name){
        if (name.length() > MAX_LENGTH){
            throw new IllegalArgumentException();
        }
    }

    private void validateIsNotEmpty(String name){
        if(name == null || name.trim().length() == 0){
            throw new IllegalArgumentException();
        }
    }
}
