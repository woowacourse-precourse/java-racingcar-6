package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    private Cars() {

    }

    public static Cars createCars() {
        return new Cars();
    }

    public void createEachCar(List<String> carStringList) {

        for (String carName : carStringList) {
            Car car = new Car(carName);
            carList.add(car);
        }
    }

    public void ifForwardCars(List<Boolean> resultRandomNumbers) {

        for (int i = 0; i < carList.size(); i++) {

            Car car = carList.get(i);

            if(resultRandomNumbers.get(i)) {
                car.forwardCar();
            }
        }
    }

    public String chooseWinner() {
        List<String> winners = new ArrayList<>();
        Integer maxMovement = 0;

        for (Car car : carList) {
            Integer carMovementCount = car.getCountingMovement();

            if(carMovementCount.equals(maxMovement)) {
                winners.add(car.getCarName());
            }

            if(carMovementCount > maxMovement) {
                winners.clear();
                winners.add(car.getCarName());
                maxMovement = carMovementCount;
            }

        }

        return String.join(", ", winners);
    }

    @Override
    public String toString() {
        StringBuilder carsMessage = new StringBuilder();

        for (Car car : this.carList) {
            carsMessage.append(car.toString());
        }

        return carsMessage.toString();
    }
}
