package racingcar.domain.car;

public class Name {
    public static final int LIMIT_LENGTH = 5;
    private String name;

    public Name(String name) {
        validationLength(name);
        this.name = name;
    }

    private void validationLength(String name) {
        if(name.length() > LIMIT_LENGTH){
            throw new IllegalArgumentException("Limit length 5");
        }
    }

    public String getName() {
        return name;
    }
}
