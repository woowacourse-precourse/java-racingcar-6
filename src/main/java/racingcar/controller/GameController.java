package racingcar.controller;

import static racingcar.constant.Constants.EXCEPTION_INT_RANGE;
import static racingcar.constant.Constants.NAME_SEPARATOR_STRING;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.validator.CarNameSplitValidator;
import racingcar.validator.RoundNumberValidator;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameController {
    private final Input input;
    private final Output output;

    private Cars cars;
    private int inputRound = 0;

    public GameController() {
        this.input = new Input();
        this.output = new Output();
    }

    public void start() {
        createCars();
        createRoundNumber();
        play();
    }

    private void play() {
        int currentRound = 0;
        output.printStartRoundMessage();
        while (currentRound < inputRound) {
            cars.playOneRound();
            cars.printRoundResult();
            currentRound++;
        }
        List<Car> winners = cars.compareWinner();
        output.printGameResult(winners);
    }

    private void createCars() {
        String validatedReadLine = getSplitValidatedString();
        List<Car> carList = splitReadLinIntoList(validatedReadLine);
        cars = new Cars(carList);
    }

    private String getSplitValidatedString() {
        output.printCarNamesInputMessage();
        String readLine = input.getReadLine();
        CarNameSplitValidator.validate(readLine);
        return readLine;
    }

    private List<Car> splitReadLinIntoList(String validatedReadLine) {
        String[] carNames = validatedReadLine.split(NAME_SEPARATOR_STRING);
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        return carList;
    }

    private void createRoundNumber() {
        String validatedRoundNumber = getValidatedRoundNumber();
        try {
            inputRound = Integer.parseInt(validatedRoundNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_INT_RANGE);
        }
    }

    private String getValidatedRoundNumber() {
        output.printRoundNumberInputMessage();
        String readLine = input.getReadLine();
        RoundNumberValidator.validate(readLine);
        return readLine;
    }
}
