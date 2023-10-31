package racingcar.domain.raingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.constant.ErrorMessage;

public class RacingCars {

    private List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        this.cars = verified(cars);
    }

    public static RacingCars fromNames(String[] inputs) {
        List<RacingCar> newCars = new ArrayList<>();

        for (String input : inputs) {
            newCars.add(new RacingCar(input));
        }

        return new RacingCars(newCars);
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public Integer getMaxPosition() {
        return cars
                .stream()
                .mapToInt(RacingCar::getPosition)
                .max().getAsInt();
    }

    private List<RacingCar> verified(List<RacingCar> cars) {
        List<String> uniqueCarNames = new ArrayList<>();

        for (RacingCar car : cars) {
            if (uniqueCarNames.contains(car.getName())) {
                throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATE_ERROR);
            }

            uniqueCarNames.add(car.getName());
        }

        return cars;
    }
}
