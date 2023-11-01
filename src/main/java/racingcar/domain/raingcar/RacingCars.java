package racingcar.domain.raingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.constant.ErrorMessage;

public class RacingCars {

    private List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        this.cars = verified(cars);
    }

    public static RacingCars fromNames(String[] inputs) {

        List<RacingCar> newCars = Arrays.stream(inputs).map(RacingCar::new).toList();
        return new RacingCars(newCars);
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public Integer getSize() {
        return cars.size();
    }

    public Integer getMaxPosition() {
        return cars.stream().mapToInt(RacingCar::getPosition).max().getAsInt();
    }

    private List<RacingCar> verified(List<RacingCar> cars) {
        List<String> uniqueCarNames = new ArrayList<>();

        cars.forEach(car -> {
            if (uniqueCarNames.contains(car.getName())) {
                throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATION_ERROR);
            }
            uniqueCarNames.add(car.getName());
        });

        return cars;
    }
}