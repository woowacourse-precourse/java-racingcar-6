package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Model {

    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Car> winnerCars = new ArrayList<>();
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
        pickWinner(cars, winnerCars);
        View.printWinner(winnerCars);
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

    private static void pickWinner(ArrayList<Car> cars, ArrayList<Car> winnercars ) {
        int maxPosition = 0;

        for (Car car : cars) {
            if (car.returnCarPosition() > maxPosition) {
                maxPosition = car.returnCarPosition();
            }
        }

        for(Car car : cars){
            if(car.returnCarPosition() == maxPosition)
                winnercars.add(car);
        }
    }
}
