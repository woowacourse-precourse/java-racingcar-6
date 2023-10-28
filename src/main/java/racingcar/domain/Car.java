package racingcar.domain;

import racingcar.view.OutputView;

public class Car implements Comparable<Car>{
    private CarName carName;
    private int movingDistance;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.movingDistance = 0;
    }

    public void printPresentMovingDistance() {
        carName.printCarName();
        OutputView.printMovingDistanceOnTurnResult(movingDistance);
    }

    public int moveRandomly() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        if (randomNumberGenerator.getRandomNumber() >= 4) {
            movingDistance++;
        }
        return movingDistance;
    }

    @Override
    public int compareTo(Car o) {
        return o.movingDistance - this.movingDistance;
    }
}
