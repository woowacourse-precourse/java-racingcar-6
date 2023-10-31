package racingcar.domain;


import racingcar.service.RandomGenerator;
import racingcar.view.Input.InputView;
import racingcar.view.Output.OutputView;

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
        String input = inputView.inputCarName();
        cars = new Cars(inputView.convertInput(input)); // Car > Cars

        int trialNumber = inputView.inputTrialNumber(); // 시도 횟수 입력 받기
        blankLine();

        for (int i = 0; i < trialNumber; i++ ) {
            moveCarIfRandomOver4();
            printResult();
            blankLine();
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
            blankLine();
        }
    }

    public void blankLine() {
        System.out.println();
    }
}
