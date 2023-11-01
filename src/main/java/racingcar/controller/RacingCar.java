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
    private int tryCount;

    public RacingCar() {
        racingCarView = RacingCarView.getInstance();
    }

    public void start() {
        List<String> nameList = inputCarName();
        createCarList(nameList);

        tryCount = inputTryCount();

        racingCarView.printEmptyLine();
        racingCarView.printResultMessage();

        for (int i = 0; i < tryCount; i++) {
            cars.move();
            racingCarView.printMoveResult(cars.getCars());
        }

        racingCarView.printWinner(cars.getLeadingCar());
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
        cars = new Cars(carList);
    }

    private int inputTryCount() {
        racingCarView.printInputTryCountMessage();

        String tryCountString = readLine();
        Validator.validateTryCount(tryCountString);

        return Integer.parseInt(tryCountString);
    }
}
