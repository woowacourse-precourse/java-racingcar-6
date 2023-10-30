package racingcar.domain.raingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.constant.ErrorMessage;

public class RacingCars {

    private static List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        cars = verified(cars);
    }


    public static List<RacingCar> fromNames(String[] inputs) {
        cars = new ArrayList<>();

        for(String input : inputs) {
            cars.add(new RacingCar(input));
        }

        return cars;
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    private List<RacingCar> verified(List<RacingCar> cars) {
        List<String> carNames = new ArrayList<>();

        for(RacingCar car : cars) {
            if (carNames.contains(car.getName())) {
                throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATE_ERROR);
            }

            carNames.add(car.getName());
        }

        return cars;
    }
}
