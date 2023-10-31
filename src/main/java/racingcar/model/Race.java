package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {

    private final int totalTrial;
    private int currentTrial;
    private final List<Car> carList;

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
        this.currentTrial += 1;
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

    public List<String> findWinner() {
        List<String> carNameList = makeCarNameList();
        List<Integer> carDriveCountList = makeCarDriveCountList();
        int maxDriveCount = Collections.max(carDriveCountList);

        return IntStream.range(0, carList.size())
                .filter(i -> carDriveCountList.get(i) == maxDriveCount)
                .mapToObj(carNameList::get)
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
