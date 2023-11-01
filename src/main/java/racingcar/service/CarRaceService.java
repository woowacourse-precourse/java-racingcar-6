package racingcar.service;

import static racingcar.constant.Delimiter.COMMA;

import java.util.List;
import racingcar.domain.Car;
import racingcar.util.Validator;

public class CarRaceService {

    private static final int INIT_MOVE_COUNT = 0;

    private final RaceService raceService = new RaceService();
    private final Validator validator = new Validator();


    public void initCarInfo(List<String> carNames, List<Car> cars) {
        for (String carName : carNames) {
            cars.add(new Car(carName, INIT_MOVE_COUNT));
        }
    }

    public List<String> extractSeperator(String carInput) {
        List<String> carNames = List.of(carInput.split(COMMA.getDelimiter()));
        validator.isRightInputFormat(carInput, carNames);
        validator.isRightCarNameInput(carNames);
        return carNames;
    }

    public Integer convertGameRoundToNumber(String carGameCount) {
        validator.isRightInputGameCount(carGameCount);
        return Integer.parseInt(carGameCount);
    }

    public List<String> roundResult(List<Car> cars) {
        return raceService.raceRoundResult(cars);
    }
}
