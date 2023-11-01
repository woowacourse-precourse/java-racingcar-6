package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Model {

    ArrayList<Car> cars = new ArrayList<>();
    int count;

    public Model() {

        for (String carName : Control.inputName()) {
            cars.add(new Car(carName, 0));
        }

        count = Control.inputCount();

        for (int i=0; i<count; i++){
            for (Car car : cars) {
                moveCar(car);
            }

            View.printPositionState(cars);
        }


    }
    private static void moveCar(Car car) {
        if (canMove()) {
            car.setCarPosition();
        }
    }

    private static Boolean canMove() {
        int randomNum = Randoms.pickNumberInRange(0, 9);

        return randomNum >= 4;
    }
}
