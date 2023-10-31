package racingcar.model;

public class Car {
    private static final String VIEW_POSITION_SIGN = "-";
    private static final int POSSIBLE_MOVE_NUMBER = 4;
    private final String name;
    private int position;
    private String viewPosition = "";

    public Car(String name) {
        this.name = name;
    }

    public void move(int randNum) {
        if (randNum < POSSIBLE_MOVE_NUMBER)
            return;
        position++;
        viewPosition += VIEW_POSITION_SIGN;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getViewPosition() {
        return viewPosition;
    }
}
