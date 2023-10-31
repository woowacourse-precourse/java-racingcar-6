package racingcar;

public class Car {
    private String name;
    private int location = 0;

    public Car(String name) {
        // validateName(name);
        this.name = name;
    }

    private void move() {
        location++;
    }

    public void moveOrStop(int fuel) {
        if (fuel >= 4) {
            move();
        }
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
