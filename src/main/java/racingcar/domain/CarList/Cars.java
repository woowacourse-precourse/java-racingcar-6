package racingcar.domain.CarList;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    public List<Car> carList = new ArrayList<Car>();

    public void setCarName(List<String> carNames) {
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    public List<CarDto> setCarMoveStatus() {
        List<CarDto> carDtos = new ArrayList<CarDto>();
        for (Car car : carList) {
            carDtos.add(car.setMoveStatus());
        }
        return carDtos;
    }

    public Car getCar(int carNumber) {
        return carList.get(carNumber);
    }

    public int carListSize() {
        return carList.size();
    }

}
