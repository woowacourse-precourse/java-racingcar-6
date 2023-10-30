package racingcar.model;

import java.util.List;

public class CarFactory {

    private final CarList carList;

    public CarFactory(CarList carList) {
        this.carList = carList;
    }

    public void generateCar(List<String> carNameList) {
        for (String carName : carNameList) {
            Car car = new Car(carName);
            carList.addCar(car);
        }
    }
}
