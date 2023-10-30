package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.validator.model.ModelValidator;

public class Cars {
    private List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;

        ModelValidator modelValidator = new ModelValidator();
        modelValidator.validate(this);
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
