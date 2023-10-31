package racingcar.model;

import java.util.List;

public class CarList {
    private List<String> carNames;
    //    private int numberRound;
    private List<Integer> carPositions;
    Car car = new Car();

    public CarList(List<String> carNames, int numberRound) {
        this.carNames = carNames;
//        this.numberRound = numberRound;
    }

    public void initialPosition() {
        for (int i = 0; i < carNames.size(); i++) {
            carPositions.add(0);
        }
    }


    public int setCarPosition(int orderOfCar) {
        if (car.isGoingForward() == true) {
            int currentPosition = carPositions.get(orderOfCar);
            carPositions.set(orderOfCar, currentPosition + 1);
        }

        return carPositions.get(orderOfCar);
    }
}
