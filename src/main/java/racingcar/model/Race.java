package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final int totalTrial;
    private int currentTrial;
    private List<Car> carList;

    public Race(int totalTrial, List<String> carNameList) {
        this.totalTrial = totalTrial;
        this.currentTrial = 0;
        this.carList = initCarList(carNameList);

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
