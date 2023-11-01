package racingcar.domain;

public class Car {
    private static final String START_POINT_STRING = "";
    private static final int START_POINT_INT = 0;
    private static final String MOVE_STRING = "-";
    private static final int THRESHOLD = 4;
    private final String name;
    private String locationString;
    private int locationInt;

    public Car(String name) {
        this.name = name;
        locationInt = START_POINT_INT;
        locationString = START_POINT_STRING;
    }

    public String getName() {
        return name;
    }

    public String getLocationString() {
        return locationString;
    }

    public int getLocationInt() {
        return locationInt;
    }

    public void move(int randomNumber) {
        if (randomNumber >= THRESHOLD) {
            locationString += MOVE_STRING;
            locationInt++;
        }
    }
}
