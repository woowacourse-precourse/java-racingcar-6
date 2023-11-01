package racingcar;

class Car {
    private final String carName;
    private int currentDistance;

    public Car(String carName) {
        this.carName = carName;
        currentDistance = 0;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getCurrentDistance() {
        return this.currentDistance;
    }

    public void move(int distance) {
        currentDistance += distance;
    }

    public void printDistance() {
        System.out.println(this.carName + " : " + "-".repeat(this.currentDistance));
    }
}
