package racingcar.model;

public class Car {
    private final String name;
    private final int forwardCount;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_ERROR = "이름은 5자 이하여야 합니다.";

    public Car(String name){
        validateLength(name);
        this.name = name;
        this.forwardCount = 0;
    }

    private void validateLength(String name) {
        if(name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

}
