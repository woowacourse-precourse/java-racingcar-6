package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.GameService;
import racingcar.util.Parser;
import racingcar.view.InputView;

public class GameController {
    private final GameService gameService;

    public GameController() {
        gameService = new GameService();
    }

    public void run() {
        InputView.printStart();

        String input = InputView.getUserInput();
        Cars cars = Parser.parseStringToCars(input);

        InputView.printAsking();
        int attempts = Integer.parseInt(InputView.getUserInput());

        InputView.printResult();
        System.out.println("attempts: " + attempts);
        List<Car> carList = cars.getCars();

        for (Car car : carList) {
            System.out.println("Car Name: " + car.getName().getName());
            System.out.println("Car Position: " + car.getPosition().getPosition());
        }

    }

}
