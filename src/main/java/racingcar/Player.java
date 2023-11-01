package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    private final List<String> carNameStore = new ArrayList<>();
    private int tryNumber;
    private List<Car> cars;

    public void settingPlayerCarNameStore(String[] carNames) {
        this.carNameStore.addAll(Arrays.asList(carNames));
    }

    public void settingPlayerTryNumber(int inputTryNumber) {
        this.tryNumber = inputTryNumber;
    }

    public void settingCarNames(List<String> carNameStore) {
        this.cars = new ArrayList<>();
        for (String carName : carNameStore) {
            createCar(carName);
        }
    }

    public List<String> getCarNameStore() {
        return carNameStore;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTryNumber() {
        return tryNumber;
    }

    private void createCar(String carName) {
        Car car = new Car(carName);
        cars.add(car);
    }
}
