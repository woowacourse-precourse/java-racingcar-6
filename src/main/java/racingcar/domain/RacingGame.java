package racingcar.domain;

import racingcar.service.RandomGenerator;
import racingcar.view.Input.InputView;
import racingcar.view.Output.OutputView;

import static racingcar.util.Util.blankLine;

public class RacingGame {
    private InputView inputView;
    private OutputView outputView;
    private RandomGenerator randomGenerator;
    private Cars cars;

    public RacingGame(InputView inputView, OutputView outputView, RandomGenerator randomGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomGenerator = randomGenerator;
    }

    public void race() {
        getCar();
        int trialNumber = geteTrialNumber();
        outputView.printResult();
        blankLine();

        while (trialNumber-- > 0) {
            moveCarIfRandomOver4();
            printResult();
            blankLine();
        }
        outputView.printWinner(new Winner(cars).maxLocationCarName());
    }

    public void getCar() {
        String input = inputView.inputCarName();
        cars = new Cars(inputView.convertInputCarName(input));
    }

    public int geteTrialNumber() {
        return inputView.convertInputTrialNumber();
    }

    public void moveCarIfRandomOver4() {
        Cars.cars.stream()
                .filter(car -> randomGenerator.isForward() == true)
                .forEach(car -> car.forward());
    }

    public void printResult() {
        Cars.cars.stream()
                .forEach(car -> {
                    String dashes = "-".repeat(car.location);
                    outputView.printResultFormat(car.carName, dashes);
                });
    }
}
