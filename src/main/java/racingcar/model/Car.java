package racingcar.model;
public class Car {

    private final String name;
    private String position;
    private final int count;

    public Car(String name, String position, int count) {
        this.name = name;
        this.position = position;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getCount() {
        return count;
    }

    public void updatePosition() {
        this.position += "-";
    }
}
