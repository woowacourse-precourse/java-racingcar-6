package racingcar.domain;

public class Car {
    private CarName carName;
    private int movingDistance;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.movingDistance = 0;
    }

    public int moveRandomly() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        if (randomNumberGenerator.getRandomNumber() >= 4) {
            movingDistance++;
        }
        return movingDistance;
    }
}
