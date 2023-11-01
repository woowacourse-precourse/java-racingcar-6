package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.car.CarController;
import racingcar.domain.car.Cars;
import racingcar.domain.car.CarsFactory;
import racingcar.domain.round.Round;
import racingcar.domain.round.RoundFactory;

import static racingcar.Constant.*;

public class GameManager {

    private final CarController carController;
    private final CarsFactory carsFactory;
    private final RoundFactory roundFactory;

    public GameManager(CarController carController, CarsFactory carsFactory, RoundFactory roundFactory) {
        this.carController = carController;
        this.carsFactory = carsFactory;
        this.roundFactory = roundFactory;
    }

    public void play() {
        Cars cars = getCars();

        Round round = getRound();

        move(cars, round);

        System.out.print(cars.getWinnersString());
    }

    private Cars getCars() {
        System.out.println(MESSAGE_INPUT_CAR_NAMES);
        String input = Console.readLine();

        return carsFactory.create(input);
    }

    private Round getRound() {
        System.out.println(MESSAGE_INPUT_ROUND);
        String input = Console.readLine();

        return roundFactory.create(input);
    }

    private void move(Cars cars, Round round) {
        System.out.println(MESSAGE_SHOW_OUTPUT);

        while (round.isLeft()) {
            carController.moveCars(cars);
            System.out.println(cars);
        }
    }
}
