package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    private final List<String> carNameStore = new ArrayList<>();
    private int tryNumber;
    private List<Car> carInfo;

    public void settingPlayerCarNameStore(String[] carNames) {
        this.carNameStore.addAll(Arrays.asList(carNames));
    }

    public void settingPlayerTryNumber(int inputTryNumber) {
        this.tryNumber = inputTryNumber;
    }

    public void settingCarNames(List<String> carNameStore) {
        this.carInfo = new ArrayList<>();
        for (String carName : carNameStore) {
            createCar(carName);
        }
    }

    public List<String> getCarNameStore() {
        return carNameStore;
    }

    public List<Car> getCarInfo() {
        return carInfo;
    }

    public int getTryNumber() {
        return tryNumber;
    }

    private void createCar(String carName) {
        Car car = new Car(carName);
        carInfo.add(car);
    }
}
