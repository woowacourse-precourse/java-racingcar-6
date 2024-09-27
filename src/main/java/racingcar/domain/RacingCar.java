package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {

    private final List<Car> racingCarList;
    private NumberGenerator numberGenerator = new NumberGenerator();

    public RacingCar(List<Car> carList) {
        racingCarList = carList;
    }

    public void moveRandomAllCar() {
        for (Car racingCar : racingCarList) {
            int randomNumber = numberGenerator.createRandomNumber();
            racingCar.canForward(randomNumber);
        }
    }

    public void printLocationAllCar() {
        for (Car racingCar : racingCarList) {
            racingCar.printLocation(racingCar);
        }
        System.out.println();
    }

    public List<Car> findWinner() {
        int maxDistance = findMaxDistance();

        return racingCarList.stream()
                .filter(car -> car.getLocation() == maxDistance)
                .collect(Collectors.toList());
    }

    public int findMaxDistance() {
        int maxDistance = 0;

        for (Car racingCar : racingCarList) {
            maxDistance = Math.max(racingCar.getLocation(), maxDistance);
        }

        return maxDistance;
    }


}
