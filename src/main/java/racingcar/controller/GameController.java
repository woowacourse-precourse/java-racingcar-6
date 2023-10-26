package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
//import racingcar.util.Parser;
import racingcar.domain.CarName;
import racingcar.domain.CarPosition;
import racingcar.util.Parser;
import racingcar.view.InputView;

public class GameController {

    private List<Car> cars;

    public void run() {
        InputView.printStart();

        String input = InputView.getUserInput();
        cars = Parser.parseStringToCars(input);

        int attempts = Integer.parseInt(InputView.getUserInput());

        InputView.printResult();

        System.out.println("attempts: " + attempts);
        for (Car car : cars) {
            CarName name = car.getName();
            CarPosition position = car.getPosition();

            String carName = name.getName();
            int carPosition = position.getPosition();

            System.out.println("carName: " + carName);
            System.out.println("carPosition: " + carPosition);
        }

    }

}
