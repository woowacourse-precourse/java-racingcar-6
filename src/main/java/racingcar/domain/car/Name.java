package racingcar.domain.car;

public class Name {
    private String name;

    public Name(String name) {
        validationLength(name);
        this.name = name;
    }

    private void validationLength(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException("Limit length 5");
        }
    }

    public String getName() {
        return name;
    }
}
