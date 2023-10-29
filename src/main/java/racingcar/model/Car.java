package racingcar.model;

public class Car {

    private String name;
    private int distance;
    private int randomNumber;

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void initCar(String name) {
        this.name = name;
        this.distance = 0;
        this.randomNumber = 0;
    }

    public void setCarRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public void addOneDistance() {
        this.distance++;
    }

}
