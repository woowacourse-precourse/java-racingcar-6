package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.Validator;

public class CarGameService {

    Validator validator = new Validator();
    RaceService raceService = new RaceService();



    public void race(List<String> carNames, Integer gameCount) {
        List<Car> cars = new ArrayList<>();
        initCarInfo(carNames,cars);
        for(int count=0; count<gameCount; count++){
            raceService.raceRoundGameStart(cars);


        }

    }

    private void initCarInfo(List<String> carNames, List<Car> cars) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<String> extractSeperator(String carInput) {
        List<String> splitedName= List.of(carInput.split(","));
        validator.isRightCarNameInput(splitedName);
        return splitedName;
    }

    public Integer convertGameCountToNumber(String carGameCount) {
        validator.isRightInputGameCount(carGameCount);
        return Integer.parseInt(carGameCount);
    }

}
