package racingcar;

public class Name {

    private String name;
    private static final int MAX_NAME_LENGTH = 5;

    private Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public static Name of(String name){
        return new Name(name);
    }

    public String getName() {
        return this.name;
    }

    private void validateNameLength(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(UserMessages.INVALID_NUMBER_INPUT.getContent());
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(UserMessages.INVALID_NUMBER_INPUT.getContent());
        }
    }
}
