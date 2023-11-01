package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList;


    public Cars(List<String> cars) {
        this.carList = InputsToCars(cars);
    }

    private List<Car> InputsToCars(List<String> inputs) {
        return inputs.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        for (Car car : carList) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return carList;
    }

    public String oneRaceResult() {
        StringBuilder raceResult = new StringBuilder();

        for (Car car : carList) {
            String carName = car.getName();
            int carPosition = car.getPosition();
            String dashes = "-".repeat(carPosition);
            String carResult = carName + " : " + dashes;
            raceResult.append(carResult).append("\n");
        }
        return raceResult.toString();
    }

}
