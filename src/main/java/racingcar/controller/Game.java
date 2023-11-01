package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.util.Validator;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    Cars cars;
    OutputView outputView;
    InputView inputView;

    public Game() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void start() {
        String carListString = inputView.inputCarNames();
        cars = new Cars(carListString);
        Validator.validateCars(cars);

        String roundNumberString = inputView.inputHowManyRound();
        int roundNumber = Validator.validateNumber(roundNumberString);
        Race race = new Race(cars, outputView);
        race.playRaceAllRounds(roundNumber);

        List<String> winners = findWinners(cars);
        outputView.printWinner(winners);
    }

    public List<String> findWinners(Cars cars) {
        List<String> winners = new ArrayList<>();

        int max = findTopDistance(cars);
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.getMovedDistance() == max) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    private int findTopDistance(Cars cars) {
        int max = 0;
        for (int i=0; i<cars.size(); i++) {
            Car car = cars.get(i);
            if (max < car.getMovedDistance()) {
                max = car.getMovedDistance();
            }
        }
        return max;
    }
}


