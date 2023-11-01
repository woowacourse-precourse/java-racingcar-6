package racingcar.model;

public class Car {
    private final String carName;
    private int distance;
    private final Engine engine;

    public Car(String carName) {
        checkCarNameLength(carName);
        this.carName = carName;
        this.engine = new Engine();
    }

    public void drive() {
        if (engine.getPower() >= 4) {
            distance += 1;
        }
    }

    public String getTrace() {
        StringBuilder sb = new StringBuilder();
        sb.append(carName).append(" : ");
        sb.append("-".repeat(Math.max(0, distance)));
        return sb.toString();
    }

    public int getDistance() {
        return distance;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getCarName() {
        return carName;
    }

    private void checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("5자리 이하의 이름을 입력해야 합니다.");
        }
    }

}
