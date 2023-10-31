package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars(List<Car> carList) {
        validateCarsNumber(carList);
        this.carList = carList;
    }

    public void allCarsForward() {
        for (Car car : this.carList) {
            car.forwardCar();
        }
    }

    public List<Car> getWinner() {
        List<Car> winnerCars = new ArrayList<>();
        int maxLocation = 0;
        for (Car car : carList) {
            if (car.currentLocation() > maxLocation) {
                maxLocation = car.currentLocation();
            }
        }
        for (Car car : carList) {
            if (car.currentLocation() == maxLocation) {
                winnerCars.add(car);
            }
        }
        return winnerCars;
    }

    public void validateCarsNumber(List<Car> carList) {
        if (carList.size() == 0) {
            throw new IllegalArgumentException();
        }
    }

    public String getWinnersName(List<Car> winnersCars) {
        List<String> winnersName = new ArrayList<>();
        for (Car car : winnersCars) {
            winnersName.add(car.getName());
        }
        return String.join(", ", winnersName);
    }

    public String toString() {
        String result = "";
        for (Car car : this.carList) {
            result += car.toString();
            result += "\n";
        }
        return result;
    }
}
