package racingcar.domain.caractions;

public class Car {
    private int distance;
    private String name;

    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public String getName(){
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void advanceCar() {
        distance += randomNumberGenerator.getNumber();
    }

}
