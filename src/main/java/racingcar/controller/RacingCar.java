package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Converter;
import racingcar.domain.Validator;
import racingcar.view.RacingCarView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCar {

    private RacingCarView racingCarView;
    private Cars cars;

    public RacingCar() {
        racingCarView = RacingCarView.getInstance();
    }

    public void start() {
        racingCarView.printInputCarNameMessage();

        String nameString = readLine();
        List<String> nameList = Converter.separatedStringToList(nameString, ",");
        Validator.validateCarsName(nameList);

        List<Car> carList = Converter.nameListToCarList(nameList);
        cars = new Cars(carList.size(), carList);
    }
}
