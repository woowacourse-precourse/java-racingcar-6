package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    private int countMaxMovement = 0;

    public void setCarsName (List<String> carStringList) {

        for (String carName : carStringList) {
            Car car = new Car(carName);
            carList.add(car);
        }
    }

    public void ifForwardCars(List<Boolean> resultRandomNumbers) {

        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            car.forwardCar(resultRandomNumbers.get(i));
        }
    }

    public String chooseWinner() {
        List<String> winners = new ArrayList<>();
        countCarsMaxMovement();

        for (Car car : carList) {

            if(car.ifImWinner(countMaxMovement)) {
                winners.add(car.getCarName());
            }

        }

        return String.join(", ", winners);
    }

    @Override
    public String toString() {
        StringBuilder carsMessgae = new StringBuilder();

        for (Car car : this.carList) {
            carsMessgae.append(car.toString());
        }

        return carsMessgae.toString();
    }

    private void countCarsMaxMovement() {
        for (Car car : this.carList) {
            if (car.carResult() > countMaxMovement) {
                countMaxMovement = car.carResult();
            }
        }
    }
}
