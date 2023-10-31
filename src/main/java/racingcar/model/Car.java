package racingcar.model;

public class Car {
    private static final int MIN_MOVE_THRESHOLD = 4;
    private static final int INIT_DISTANCE = 0;
    private static final String HYPHEN = "-";
    private static final String COLON = " : ";

    private final String name;
    private int distance;

    private Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car createCar(String name) {
        return new Car(name, INIT_DISTANCE);
    }

    public void move(int randomNumber) {
        if (isMovePossible(randomNumber)) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    private boolean isMovePossible(int randomNumber) {
        return randomNumber >= MIN_MOVE_THRESHOLD;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name)
                .append(COLON)
                .append(HYPHEN.repeat(distance));
        return sb.toString();
    }
}
