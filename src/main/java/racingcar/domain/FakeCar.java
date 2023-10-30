package racingcar.domain;

public class FakeCar implements Car {

    protected final String name;
    protected int distance;

    public FakeCar(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public boolean isMaxDistance(int maxDistance) {
        return distance == maxDistance;
    }

    @Override
    public void attemptToMove() {
        distance++;
    }
}
