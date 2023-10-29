package racingcar;

public class Car {

    private final String name;
    private int location;

    public Car (String name) {
        if (isInvalidCarName(name)) {
            Exception.generateInvalidCarNameLengthException();
        }
        this.name = name;
        this.location = 0;
    }

    void moveForward() {
        location++;
    }

    String getName() {
        return name;
    }

    int getLocation() {
        return location;
    }

    boolean isInvalidCarName(String name) {
        if (name.length() > 5) {
            return true;
        }
        return false;
    }

}
