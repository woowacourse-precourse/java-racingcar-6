package racingcar;

public final class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        validation(name);
        this.name = name;
        this.distance = 0;
    }

    public void run(int randomValue) {
        if (randomValue >= 4) {
            this.distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    private void validation(String name) {
        if (!Util.CARS_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException("자동차 이름은 1글자에서 5글자 사이의 알파벳만 가능해요.");
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}
