package racingcar.controller;

import static racingcar.constant.Message.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final Validator validator = Validator.getInstance();
    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;
    private int rounds;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = Objects.requireNonNull(inputView);
        this.outputView = Objects.requireNonNull(outputView);
    }

    public void start() {
        String namesInput = inputView.askCarNames();
        initCars(namesInput);

        String roundInput = inputView.askRound();
        System.out.println();

        setRounds(roundInput);
        runRounds(rounds);

        printWinner();
    }

    private void initCars(String input) {
        List<Car> carList = new ArrayList<>();
        List<String> carNameList = validator.checkValidInputList(input);

        for (String name : carNameList) {
            Car car = new Car(name);
            carList.add(car);
        }
        cars = new Cars(carList);
    }

    private void setRounds(String input) {
        rounds = validator.checkValidInputNumber(input);
    }

    private void runRounds(int rounds) {
        outputView.printMessage(ROUND_RESULT_SUBJECT);

        for (int i=1; i<=rounds; i++) {
            cars.moveCars();
            List<String> resultList = cars.getRoundResult();

            printRoundResult(resultList);
        }
    }

    private void printRoundResult(List<String> resultList) {
        for (String result: resultList) {
            outputView.printMessage(result);
        }
            outputView.printMessage();
    }

    private void printWinner() {
        String winner = String.join(", ", cars.getWinner());
        String result = RESULT_SUBJECT.getValue() + winner;

        outputView.printMessage(result);
    }
}
