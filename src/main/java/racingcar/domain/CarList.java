package racingcar.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.utils.Constants;

public class CarList {
    private final List<Car> carList;

    public CarList(List<Car> carList) {
        validateCarNameDuplication(carList);
        this.carList = carList;
    }

    public void validateCarNameDuplication(List<Car> cars){
        if(cars.stream().map(Car::getName).collect(Collectors.toSet()).size() != cars.size()){
            throw new IllegalArgumentException(Constants.ERROR_CAR_NAME_DUPLICATION);
        }
    }


}
