package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.service.GameService;
import racingcar.utils.InputValidator;
import racingcar.view.GameInputView;

public class GameController {
    private final GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    public void start() {
        GameInputView.printStartMessage();

        String carNameInput = readLine();
        InputValidator.checkHasComma(carNameInput);

        List<String> carNames = getCarNames(carNameInput);

        GameInputView.printTryInputMessage();
        String tryCount = readLine();

        gameService.start(carNames, tryCount);
    }

    private List<String> getCarNames(String carNameInput) {
        String[] split = carNameInput.split(",");
        return List.of(split);
    }
}
