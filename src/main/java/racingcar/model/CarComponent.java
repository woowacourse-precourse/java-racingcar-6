package racingcar.model;

public class CarComponent {
    private String name;
    private int distance;

    public CarComponent(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void addDistance(int distance) {
        this.distance += distance;
    }
}
