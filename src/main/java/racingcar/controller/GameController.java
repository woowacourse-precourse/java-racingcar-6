package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.RoundService;
import racingcar.util.RandomNumberImpl;
import racingcar.validator.CarNameSplitValidator;
import racingcar.validator.RoundNumberValidator;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameController {
    private static final int NOT_FOUND_SCORE = -1;
    private final RoundService roundService;
    private final Input input;
    private final Output output;

    private Cars cars;
    private int roundNumber = 0;

    public GameController() {
        this.roundService = new RoundService(new RandomNumberImpl());
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
        while (currentRound < roundNumber) {
            cars.playOneRound();
            cars.printRoundResult();
            currentRound++;
        }
        List<Car> winners = cars.compareWinner();
        output.printGameResult(winners);
    }

    private void createCars() {
        output.printCarNamesInputMessage();
        String readLine = input.getReadLine();
        CarNameSplitValidator.validate(readLine);

        String[] carNames = readLine.split(",");
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        cars = new Cars(carList);
    }

    private void createRoundNumber() {
        output.printRoundNumberInputMessage();
        String readLine = input.getReadLine();
        RoundNumberValidator.validate(readLine);
        try {
            roundNumber = Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("가능한 최댓값을 초과하였습니다.");
        }
    }
}
