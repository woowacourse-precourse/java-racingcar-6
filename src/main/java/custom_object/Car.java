package custom_object;

public class Car {
    private String name;
    private int position = 0;
    private final int MOVE_THRESHOLD = 4;

    public Car(String name) {
        this.name = name;
    }

    public void tryMoving(Integer number) {
        if (number >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public Integer getPosition() {
        return this.position;
    }
}
