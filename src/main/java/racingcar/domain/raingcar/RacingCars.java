package racingcar.domain.raingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.constant.ErrorMessage;

public class RacingCars {
    private List<RacingCar> cars = new ArrayList<>();

    public RacingCars(String[] inputCars) {
        for(String name : inputCars) {
            verify(name);
            cars.add(new RacingCar(name));
        }
    }

    private void verify(String name) {
        if(cars.contains(name)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATE_ERROR);
        }
    }
}
