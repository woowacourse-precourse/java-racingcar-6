package racingcar;

class Car {
    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }

}
