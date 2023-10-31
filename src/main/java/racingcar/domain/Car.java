package racingcar.domain;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void accountDistance() {
        this.distance += 1;
    }

    public void printMove() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.distance; i++) {
            System.out.print("-");
        }
    }
}
