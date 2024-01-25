package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.constants.GameResultElement;
import racingcar.constants.RacingCarRole;
import racingcar.constants.message.ErrorMessage;
import racingcar.exception.car.CarsCountException;

public class Cars {

    public static final String DIVISION = ",";
    private static final int INITIAL_POSITION = 0;
    private final List<Car> racingCars;

    public Cars(String carNames) {
        this.racingCars = Arrays.stream(carNames.split(DIVISION))
            .map(Car::new)
            .toList();
        validateCarsCount();
    }

    private void validateCarsCount() {
        if (racingCars.size() < RacingCarRole.MIN_CARS_COUNT.getValue()) {
            throw new CarsCountException(ErrorMessage.CARS_COUNT_ERROR.getMessage());
        }
    }

    public String statusCarsPosition() {
        StringBuilder stringBuilder = new StringBuilder();

        racingCars.forEach(car -> stringBuilder.append(car.statusCarPosition()));

        return stringBuilder.toString();
    }

    public String getFinalWinners() {
        List<String> winners = racingCars.stream()
            .filter(car -> car.isEqualCarPosition(findCarMaxPosition()))
            .map(Car::getName)
            .toList();
        return String.join(GameResultElement.COMMA.getElement(), winners);
    }

    private int findCarMaxPosition() {
        return racingCars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(INITIAL_POSITION);
    }

    public List<Car> getRacingCars() {
        return List.copyOf(racingCars);
    }
}
