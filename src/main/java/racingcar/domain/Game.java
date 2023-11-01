package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.constants.PrintMesssages;
import racingcar.util.InputHandler;
import racingcar.util.OutputHandler;

public class Game {
    private Cars cars;
    private Rounds rounds;
    private String carNames;
    private Integer totalRounds;

    public Game(Cars cars, Rounds rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public void start() {
        getUserInputs();
        roundsInit();
        startRounds();
        showWinner();
    }

    private void getUserInputs() {
        OutputHandler.showMessageWithNewLine(PrintMesssages.PROMPT_RACING_CARS_NAME);
        carNames = InputHandler.getUserInputString();

        OutputHandler.showMessageWithNewLine(PrintMesssages.PROMPT_GAME_ROUNDS);
        totalRounds = InputHandler.getUserInputNumber();
    }

    private void roundsInit() {
        cars.registerCar(carNames);
        rounds.makeRounds(totalRounds);
    }

    private void startRounds() {
        for (Round round : rounds.getRounds()) {
            round.start(cars);
        }
    }

    private void showWinner() {
        StringBuilder messages = new StringBuilder();
        messages.append("최종 우승자 : ");

        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars.getMaxMoveCars()) {
            winnerNames.add(car.getName());
        }
        messages.append(String.join(", ", winnerNames));

        OutputHandler.showMessageWithOutNewLine(messages.toString());
    }
}
