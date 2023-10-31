package racingcar.domain;


import racingcar.service.RandomGenerator;
import racingcar.view.Input.InputView;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import static racingcar.domain.Cars.cars;

public class RacingGame {
    private InputView inputView;
    private Cars cars;
    private RandomGenerator randomGenerator;

    public RacingGame(InputView inputView, RandomGenerator randomGenerator) {
        this.inputView = inputView;
        this.randomGenerator = randomGenerator;
    }

    public void goOrStop() {
        cars = new Cars(inputView.inputCarName());
        int trialNumber = inputView.inputTrialNumber();

        for (int i = 0; i < trialNumber; i++ ) {
            moveCarIfRandomOver4();
            printResult();
        }
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
