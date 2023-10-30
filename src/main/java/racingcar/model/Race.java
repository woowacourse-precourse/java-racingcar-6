package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private final int totalTrial;
    private int currentTrial;
    private List<Car> carList;

    public Race(int totalTrial, List<String> carNameList) {
        this.totalTrial = totalTrial;
        this.currentTrial = 0;
        this.carList = initCarList(carNameList);

    }

    public boolean isFinish() {
        return totalTrial == currentTrial;
    }

    public void runRace() {
        for (Car car : carList) {
            car.decideDrive();
        }
    }

    public List<String> makeCarNameList() {
        return carList.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public List<Integer> makeCarDriveCountList() {
        return carList.stream()
                .map(Car::getDriveCount)
                .collect(Collectors.toList());
    }


    public List<Car> initCarList(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();
        Car car;
        for (String carName : carNameList) {
            car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

}
