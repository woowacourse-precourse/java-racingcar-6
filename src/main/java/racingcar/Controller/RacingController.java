package racingcar.Controller;

import racingcar.Model.Cars;
import racingcar.Model.CarsFactory;
import racingcar.Util.Parser;
import racingcar.Util.Validator;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class RacingController {
    CarsFactory carsFactory = new CarsFactory();

    public void run() {
        Cars cars = createCars();
        int rounds = getRounds();
        startRacing(cars, rounds);
    }

    private Cars createCars() {
        String input = InputView.requestCarNames();
        Validator.validateCarNames(input);
        String[] carNames = Parser.parseString(input);
        Cars cars = carsFactory.generateCars(carNames);
        return cars;
    }

    private static int getRounds() {
        String rounds = InputView.requestRounds();
        Validator.validateRounds(rounds);
        int convertedRounds = Integer.parseInt(rounds);
        return convertedRounds;
    }

    private static void startRacing(Cars cars, int rounds) {
        for (int i=0; i < rounds; i++) {
            cars.move();
            OutputView.printRoundResult(cars.getCars());
        }
        OutputView.printWinners(cars.getWinners());
    }

}
