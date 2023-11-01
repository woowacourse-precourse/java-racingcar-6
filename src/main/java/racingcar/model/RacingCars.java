package racingcar.model;

import racingcar.enums.Exceptions;
import racingcar.exception.CarNameDuplicateException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCars {
    List<Car> racingCars;
    public RacingCars(List<Car> racingCars) {
        validateDuplicateCarName(racingCars);
        this.racingCars = racingCars;
    }

    public static List<Car> convertToCarList(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(new Name(carName), new Distance());
            carList.add(car);
        }
        return carList;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public void updateRacingCars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    private void validateDuplicateCarName(List<Car> racingCars) {
        Set<Car> cars = new HashSet<>();

        for (Car car : racingCars) cars.add(car);

        if (racingCars.size() != cars.size()) {
            throw new CarNameDuplicateException(Exceptions.DUPLICATE_CAR_NAME.getMessage());
        }
    }
}
