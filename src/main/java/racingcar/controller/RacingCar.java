package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Converter;
import racingcar.domain.Validator;
import racingcar.view.RacingCarView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCar {

    private final RacingCarView racingCarView;
    private Cars cars;

    public RacingCar() {
        racingCarView = RacingCarView.getInstance();
    }

    public void start() {
        List<String> nameList = inputCarName();
        createCarList(nameList);

        inputTryCount();
    }

    private List<String> inputCarName() {
        racingCarView.printInputCarNameMessage();
        String nameString = readLine();

        List<String> nameList = Converter.separatedStringToList(nameString, ",");
        Validator.validateCarsName(nameList);

        return nameList;
    }

    private void createCarList(List<String> nameList) {
        List<Car> carList = Converter.nameListToCarList(nameList);
        cars = new Cars(carList.size(), carList);
    }

    private void inputTryCount() {
        racingCarView.printInputTryCountMessage();

        String countString = readLine();
    }
}
