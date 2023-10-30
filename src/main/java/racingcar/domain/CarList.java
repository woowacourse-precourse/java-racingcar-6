package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.Constants;

public class CarList {
    private final List<Car> carList;

    public CarList(List<Car> carList) {
        validateCarNameDuplication(carList);
        this.carList = carList;
    }


    public void validateCarNameDuplication(List<Car> cars) {
        if (cars.stream().map(Car::getName).collect(Collectors.toSet()).size() != cars.size()) {
            throw new IllegalArgumentException(Constants.ERROR_CAR_NAME_DUPLICATION);
        }
    }

    public List<Integer> moveAll() {
        return carList.stream()
                .map(i -> i.move(Randoms.pickNumberInRange(Constants.MINIMUM_RANGE, Constants.MAXIMUM_RANGE)))
                .collect(Collectors.toList());
    }

    public String carsStatus() {
        return carList.stream().map(car -> car.getName() + " : " + "-".repeat(car.getPosition()))
                .collect(Collectors.joining("\n"));
    }

    public int size(){
        return carList.size();
    }

}
