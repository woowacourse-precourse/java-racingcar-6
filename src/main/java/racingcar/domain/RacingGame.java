package racingcar.domain;


import static racingcar.util.Util.blankLine;
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

    public void race() {
        getCar();
        blankLine();
        int trialNumber = geteTrialNumber();

        while (trialNumber-- > 0) {
            moveCarIfRandomOver4();
            printResult();
            blankLine();
        }
        outputView.printWinner(new Winner(cars).maxLocationCarName());
    }

    public void getCar() {
        String input = inputView.inputCarName();
        cars = new Cars(inputView.convertInputCarName(input)); // Car > Cars
    }

    public int geteTrialNumber() {
        return inputView.convertInputTrialNumber(); // 시도 횟수 입력 받기
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
                    System.out.println(car.carName + " : " + dashes);
                    blankLine();
                });
    }


}
