package racingcar.model;

public class Car {
    private String name;
    private int distance=0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public void move(int randomNum, int standard) {
        if (randomNum >= standard) {
            this.distance++;
        }
    }
}
