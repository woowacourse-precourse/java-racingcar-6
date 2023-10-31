package racingcar.domain;

public class Car {
    private final String name;
    private String positionString;
    private int positionInt;

    public Car(String name) {
        this.name = name;
        positionString = "";
        positionInt = 0;
    }

    public void move(int randomNum) {
        if (randomNum >= 4) {
            positionString += "-";
            positionInt += 1;
        }
    }

    public String getName() {
        return name;
    }

    public String getPositionString() {
        return positionString;
    }

    public int getPositionInt() {
        return positionInt;
    }
}
