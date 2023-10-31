package racingcar.model;

public class CarDto {
    private final int distance;
    private final String name;

    public CarDto(String name, int distance) {
        this.distance = distance;
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public boolean isfathestDistance(int farthestDistance) {
        return this.distance == farthestDistance;
    }

}
