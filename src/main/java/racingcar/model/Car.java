package racingcar.model;


public class Car {
    private final static int MOVING_STANDARD = 4;
    private final static int MAX_NAME_LENGTH = 5;

    private final String name;
    private int location = 0;

    public Car(String name) {
        this.name = validateNameLength(name);
    }


    public int move(int randomNumber) {
        if (isMoveFront(randomNumber)) {
            location++;
        }
        return location;
    }

    private boolean isMoveFront(int randomNumber) {
        return randomNumber >= MOVING_STANDARD;
    }


    private String validateNameLength(String name) throws IllegalStateException {
        if(name != null && name.length() <= MAX_NAME_LENGTH){
            return name;
        }
        throw new IllegalStateException();
    }
}
