package racingcar.domain.subclass;


public class MockCar implements Comparable<MockCar> {
    private final String name;

    private int totalMovedDistance;

    public MockCar(String name) {
        this.name = name;
        this.totalMovedDistance = 0;
    }

    public MockCar(String name, int totalMovedDistance) {
        this.name = name;
        this.totalMovedDistance = totalMovedDistance;
    }

    public void move() {
        totalMovedDistance += 1;
    }

    public String getName() {
        return name;
    }

    public int getTotalMovedDistance() {
        return totalMovedDistance;
    }

    @Override
    public int compareTo(MockCar other) {
        return this.totalMovedDistance - other.totalMovedDistance;
    }

    public boolean isSamePosition(MockCar other){
        return this.totalMovedDistance ==  other.totalMovedDistance;
    }
}
