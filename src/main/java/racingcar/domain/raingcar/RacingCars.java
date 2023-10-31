package racingcar.domain.raingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.constant.ErrorMessage;

public class RacingCars {

    private static List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        cars = verified(cars);
    }

    public static List<RacingCar> fromNames(String[] inputs) {
        cars = new ArrayList<>();

        for (String input : inputs) {
            cars.add(new RacingCar(input));
        }

        return cars;
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public Integer getMaxPosition() {
        return cars
                .stream()
                .max(Comparator.comparing(RacingCar::getPosition))
                .get().getPosition();
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
