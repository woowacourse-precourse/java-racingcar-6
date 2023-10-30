package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.exception.NullException;
import racingcar.exception.cars.DuplicateException;
import racingcar.validator.model.CarsValidator;
import racingcar.validator.model.ModelValidator;

public class Cars {
    private List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;

        CarsValidator.getInstance().validate(this);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Integer> getPositionList() {
        List<Integer> positions = new ArrayList<>();
        carList.forEach(car -> positions.add(car.getPosition()));
        return positions;
    }

    public Car get(int index) {
        return carList.get(index);
    }

    public int size() {
        return carList.size();
    }
}
