package racingcar.model;

public class ScoreDto {
    private final int distance;
    private final String name;

    public ScoreDto(String name, int distance) {
        this.distance = distance;
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public boolean isSameDistance(int farthestDistance) {
        return this.distance == farthestDistance;
    }

}
