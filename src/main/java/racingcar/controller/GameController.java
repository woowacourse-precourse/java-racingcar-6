package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.CarCreator;
import racingcar.model.NumberEnum;
import racingcar.service.RacingService;
import racingcar.service.UserService;
import racingcar.view.InputMessage;
import racingcar.view.OutputMessage;

public class GameController {
    private final OutputMessage outputMessage = new OutputMessage();
    private final InputMessage inputCarNameMessage = new InputMessage();
    private final UserService userService = new UserService();
    private final RacingService racingService = new RacingService();
    private final CarCreator carCreator = new CarCreator();


    public void StartGame() {
        inputCarNameMessage.inputCarNameMessage();
        List<String> carNames = carCreator.createCarList(userService.inputItem());
        inputCarNameMessage.inputTryNumberMessage();
        int tryNumber = userService.inputTryNumber(userService.inputItem());
        outputMessage.resultMessage();
        List<Integer> movement = createMovementList(carNames);
        for (int i = 0; i < tryNumber; i++) {
            racingGame(movement);
            outputMessage.raceStatusMessage(carNames, movement);
        }
        outputMessage.winnerMessage(racingResult(carNames, movement));
    }

    private List<Integer> racingGame(List<Integer> movement) {
        for (int i = 0; i < movement.size(); i++) {
            if (racingService.moveOrStop()) {
                movement.set(i, movement.get(i) + 1);
            }
        }
        return movement;
    }

    private List<Integer> createMovementList(List<String> carNames) {
        List<Integer> movement = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            movement.add(0);
        }
        return movement;
    }

    private List<String> racingResult(List<String> carNames, List<Integer> movement) {
        List<String> winner = new ArrayList<>();

        List<Integer> winnerIndex = getWinnerIndex(movement);
        for (int i = 0; i < winnerIndex.size(); i++) {
            winner.add(carNames.get(winnerIndex.get(i)));
        }
        return winner;
    }

    private List<Integer> getWinnerIndex(List<Integer> movement) {
        int maxMove = movement.stream()
                .max(Integer::compareTo)
                .orElse(0);

        return IntStream.range(NumberEnum.ZERO.getNumber(), movement.size())
                .filter(i -> movement.get(i) == maxMove)
                .boxed()
                .toList();
    }
}
