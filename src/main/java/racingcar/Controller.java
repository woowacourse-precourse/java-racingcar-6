package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Race race;
    private static final String DELIMITER_COMMA = ",";

    private List<Car> getInputForCarNames() {
        String inputForCarName = View.getCarNames();
        String[] carNames = inputForCarName.split(DELIMITER_COMMA);
        return createCarsFromCarNames(carNames);
    }

    private List<Car> createCarsFromCarNames(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            CarName carNameObject = new CarName(carName);
            cars.add(new Car(carNameObject.getName()));
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
