package racingcar;

import camp.nextstep.edu.missionutils.Randoms; import java.util.ArrayList;

public class CarModel {
    private final ArrayList <CarObject> CARS = new ArrayList<>();
    private final ArrayList <CarObject> WINNERS = new ArrayList<>();

    public CarModel() {
        for (String carName : CarControl.inputName()) {
            CARS.add(new CarObject(carName, 0));
        }

        int count = CarControl.inputCount();

        for (int i = 0; i < count; i++) {
            for (CarObject car : CARS) {
                moveCar(car);
            }
            CarView.printPositionState(CARS);
        }

        pickWinner();
        CarView.printWinner(WINNERS);
    }

    private void moveCar(CarObject car) {
        if (canMove()) {
            car.setCarPosition();
        }
    }

    private Boolean canMove() {
        int randomNum = Randoms.pickNumberInRange(0, 9);

        return randomNum >= 4;
    }

    private void pickWinner() {
        int maxPosition = 0;

        for (CarObject car : CARS) {
            if (car.getCarPosition() > maxPosition) {
                maxPosition = car.getCarPosition();
            }
        }

        for(CarObject car : CARS) {
            if(car.getCarPosition() == maxPosition) {
                WINNERS.add(car);
            }
        }
    }
}