package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.util.InputValidator;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public void start() {
        String carNamesInput = inputAndValidateCarNames();
        int roundCount = inputAndValidateRound();

        System.out.println();

        List<Car> cars = createCars(carNamesInput);

        System.out.println("실행 결과");

        Race race = new Race(cars, new RandomMoveStrategy());
        for (int currentRound = 0; currentRound < roundCount; currentRound++) {
            race.oneRound();
            race.printProgress();
        }

        System.out.print("최종 우승자 : " + race.getWinners());
    }

    private String inputAndValidateCarNames() {
        String carNamesInput = InputView.inputCarNames();
        InputValidator.validateCarNames(carNamesInput);

        return carNamesInput;
    }

    private int inputAndValidateRound() {
        String roundInput = InputView.inputRound();
        InputValidator.validateRound(roundInput);

        return Integer.parseInt(roundInput);
    }

    private List<Car> createCars(String input) {
        List<Car> cars = new ArrayList<>();
        for (int carIndex = 0; carIndex < input.split(",").length; carIndex++) {
            Car car = new Car(input.split(",")[carIndex]);

            cars.add(car);
        }

        return cars;
    }
}
