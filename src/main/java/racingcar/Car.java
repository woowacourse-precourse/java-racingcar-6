package racingcar;

public class Car {
    private static final int MOVE_SPEED = 1;
    private static final String DISPLAY_BAR = "-";
    private final String name;
    private int position = 0;
    private String display = "";

    Car(String name) {
        this.name = name;
        this.display = this.name + " : ";
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public String getDisplay() {
        return this.display;
    }

    public void move() {
        this.position += MOVE_SPEED;
        this.display += DISPLAY_BAR;
    }
}
