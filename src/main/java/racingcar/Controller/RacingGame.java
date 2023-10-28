package racingcar.Controller;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;

import camp.nextstep.edu.missionutils.Console;
import racingcar.View.InputView;
import racingcar.Validator;
import racingcar.Model.Car;
import racingcar.Model.Cars;

public class RacingGame {
    private Validator validator = new Validator();

    public void run() {
        String carname = carNamesInput();
        Cars cars = createCars(carname);
        int playCount = playCountInput();
        for (int i = 0; i < cars.getCars().size(); i++) {
            System.out.println(cars.getCars().get(i).getName());
        }
    }

    private Cars createCars(String input) {
        List<Car> carList = returnCarList(splitCarNames(input));
        Cars cars = new Cars(carList);
        return cars;
    }

    private List<Car> returnCarList(List<Object> carNames) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            carList.add(new Car(carNames.get(i).toString()));
        }
        return carList;
    }

    private List<Object> splitCarNames(String input) {
        List<Object> carNames = Arrays.asList(input.split(","));
        return carNames;
    }

    private String carNamesInput() {
        InputView.requestCarNames();
        String input = Console.readLine();
        return input;
    }

    private int playCountInput() {
        InputView.requestPlayCount();
        String input = Console.readLine();
        int playCount = validator.validatePlayCount(input);
        return playCount;
    }
}
