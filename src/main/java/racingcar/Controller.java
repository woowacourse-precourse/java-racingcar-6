package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Race race;
    private static final String DELIMITER_COMMA = ",";
    private static final int MAX_LENGTH_CAR_NAME = 5;
    private static final String ERROR_BLANK_CAR_NAME = "자동차 이름은 공백은 불가합니다.";
    private static final String ERROR_MAX_LENGTH_CAR_NAME = "자동차 이름은 5자 이하만 가능합니다.";

    private List<Car> getInputForCarNames() {
        String inputForCarName = View.getCarNames();
        String[] carNames = inputForCarName.split(DELIMITER_COMMA);
        return createCarsFromCarNames(carNames);
    }

    private void validateCarName(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(ERROR_BLANK_CAR_NAME);
        }
        if (carName.length() > MAX_LENGTH_CAR_NAME) {
            throw new IllegalArgumentException(ERROR_MAX_LENGTH_CAR_NAME);
        }
    }

    private List<Car> createCarsFromCarNames(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            validateCarName(carName);
            cars.add(new Car(carName));
        }
        return cars;
    }

    private TryCount getInputForTryCount() {
        String inputForTryCount = View.getTryCount();
        return new TryCount(inputForTryCount);
    }

    public void prepareRace() {
        List<Car> cars = getInputForCarNames();
        TryCount tryCount = getInputForTryCount();

        race = new Race(cars, tryCount);
    }

    public void startRace() {
        View.printResultAlarm();
        race.conductRace();
    }

    public void announceResult() {
        List<String> winners = race.getWinners();
        View.printFinalWinner(String.join(", ", winners));
    }
}
