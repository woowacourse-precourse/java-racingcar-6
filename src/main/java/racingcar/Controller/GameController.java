package racingcar.Controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.domain.Car;
import racingcar.domain.RacingCar;
import racingcar.domain.Splitter;
import racingcar.domain.Validator;

public class GameController {

    private InputView userInputer = new InputView();
    private OutputView outputView = new OutputView();
    private Splitter splitter = new Splitter();
    private Validator validator = new Validator();

    private RacingCar racingCar;

    public void start() {
        List<Car> carList = askCarNames();
        racingCar = new RacingCar(carList);

        int trialCount = askTryCount();
        startRacing(trialCount);

        printWinners();
    }

    public void startRacing(int repeatCount) {
        System.out.println("실행 결과");
        raceAll(repeatCount);

    }

    public void raceAll(int repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            racingCar.moveRandomAllCar();
            racingCar.printLocationAllCar();
        }
    }


    public void printWinners() {
        List<Car> winnerList = racingCar.findWinner();

        String winnerNames = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        outputView.printFinalWinner();
        System.out.println(winnerNames);
    }

    public List<Car> askCarNames() {
        outputView.printStartIntro();
        String userInput = userInputer.inputCarString();
        Validator.valideteIsEmpty(userInput);
        Validator.validateIsBlank(userInput);
        List<String> carNameList = splitter.stringToList(userInput);
        validator.validateCarNameLength(carNameList);
        List<Car> carList = splitter.makeCar(carNameList);

        return carList;
    }

    public int askTryCount() {
        outputView.printNumberOfAttempts();
        String tryNumber = userInputer.inputTryCount();
        validator.validateIsNumber(tryNumber);

        return Integer.parseInt(tryNumber);
    }
}
