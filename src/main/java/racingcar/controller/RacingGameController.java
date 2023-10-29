package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    Game game;
    Verification verification = new Verification();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        inputView.carName();
        List<String> carNames = inputCarName();

        inputView.round();
        int round = inputRound();

        game = new Game(carNames, round);
        outputView.resultPhrase();

        for(int i = 0; i < game.getRound(); i++) {
            goForward(game);
            outputView.resultByRound(game);
        }

        List<String> winners = winners(game);
        outputView.winners(winners);
    }

    public List<String> inputCarName() {
        String input = Console.readLine();
        List<String> carNames = new ArrayList<>();

        carNames.addAll(Arrays.asList(splitInput(input)));

        verification.verifyCarName(carNames);

        return carNames;
    }

    public String[] splitInput(String input) {
        String[] splitedInput = input.split(",");

        return splitedInput;
    }

    public int inputRound() {
        String input = Console.readLine();

        verification.verifyRound(input);

        return Integer.parseInt(input);
    }

    public void goForward(Game game) {
        Car[] cars = game.getCars();
        for(Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.goForward();
            }
        }
    }

    public List<String> winners(Game game) {
        Car[] cars = game.getCars();
        List<String> winners = new ArrayList<>();
        int LongestStep = cars[0].getStep().length();

        for(Car car : cars) {
            LongestStep = Math.max(LongestStep, car.getStep().length());
        }

        for(Car car : cars) {
            if(car.getStep().length() == LongestStep) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
