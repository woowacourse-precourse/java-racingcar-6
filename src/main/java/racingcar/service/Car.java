package racingcar.service;

public class Car {

    private Distance distance;
    private final String carName;
    private final static Integer ADVANCE_STEP = 1;

    public Car(String name) {
        this.distance = new Distance(0);
        this.carName = name;
    }

    public static Car toEntity(String carName) {
        return new Car(carName);
    }

    public void advance() {
        Integer preDistance = distance.getDistance();
        this.distance = new Distance(preDistance + ADVANCE_STEP);
    }

    @Override
    public String toString() {
        return String.format("%s : %s\n", carName, distance);
    }

    public int updateMaxDistance(int maxDistance) {
        return Math.max(distance.getDistance(), maxDistance);
    }

    public boolean isAtMaxDistance(int maxDistance) {
        return distance.getDistance() == maxDistance;
    }

    public String getCarName() {
        return carName;
    }
}
