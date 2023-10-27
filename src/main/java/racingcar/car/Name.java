package racingcar.car;

public class Name {
    private final static int NAME_SIZE = 5;
    private final String  value;

    public Name(String name) {
        if (name.length() > NAME_SIZE) {
            throw new IllegalArgumentException();
        }
        this.value = name;
    }

    public String getValue() {
        return value;
    }

}
