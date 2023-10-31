package racingcar.domain;


import racingcar.service.RandomGenerator;
import racingcar.view.Input.InputView;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import racingcar.view.Output.OutputView;

import static racingcar.domain.Cars.cars;

public class RacingGame {
    private InputView inputView;
    private OutputView outputView;
    private Cars cars;
    private RandomGenerator randomGenerator;

    public RacingGame(InputView inputView, OutputView outputView, RandomGenerator randomGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomGenerator = randomGenerator;
    }

    public void goOrStop() {
        String input = inputView.inputCarName(); // 자동차 입력 받기

        cars = new Cars(inputView.carName(input)); // Car > Cars

        int trialNumber = inputView.inputTrialNumber(); // 시도 횟수 입력 받기

        for (int i = 0; i < trialNumber; i++ ) {
            moveCarIfRandomOver4();
            printResult();
            System.out.println("");
        }
        Winner winner = new Winner(cars);
        outputView.printWinner(winner.maxLocationCarName());
    }

    public void moveCarIfRandomOver4() {
        for (Car car : Cars.cars) {
            if (randomGenerator.generateRandom()) {
                car.forward();
            }
        }
    }

    public void printResult() {
        for (Car car : Cars.cars) {
            System.out.print(car.carName + " : ");
            for (int i = 0; i < car.location; i++) {
                System.out.print("-");
            }
            System.out.println("");
        }
    }
}
