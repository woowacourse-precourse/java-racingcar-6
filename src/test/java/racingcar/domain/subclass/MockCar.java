package racingcar.domain.subclass;


import racingcar.domain.RandomNumberGenerator;
import racingcar.system.SystemConstant;

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
        int randomValue = RandomNumberGenerator.randomNumGenerate();
        if (randomValue >= SystemConstant.MIN_MOVE_THRESHOLD) {
            totalMovedDistance++;
        }
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

    public boolean isSamePosition(MockCar other) {
        return this.totalMovedDistance == other.totalMovedDistance;
    }
}
