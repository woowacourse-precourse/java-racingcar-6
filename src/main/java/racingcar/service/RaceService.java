package racingcar.service;


import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;

public class RaceService {

    private final ValidationService validationService;

    public RaceService() {
        validationService = new ValidationService();
    }

    public Cars initializeCars(List<String> carNamesInput) {
        List<String> carNames = validationService.validateCarNamesInput(carNamesInput);
        return new Cars(carNames);
    }

    public int initializeCount(String countInput) {
        return validationService.validateNumericInput(countInput);
    }

    public List<Car> runRace(Race race) {
        race.run();
        return race.getCars();
    }
}
