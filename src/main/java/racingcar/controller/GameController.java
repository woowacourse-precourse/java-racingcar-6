package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.dto.InputDto;
import racingcar.service.GameService;
import racingcar.utils.InputValidator;
import racingcar.view.GameInputView;

public class GameController {
    private final GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    public void start() {
        List<String> carNames = enterCarNames();
        int tryNum = enterTryNum();

        InputDto inputDto = new InputDto(carNames, tryNum);

        gameService.processStart(inputDto);
    }

    private List<String> enterCarNames() {
        GameInputView.printStartMessage();
        String carNameInput = readLine();
        InputValidator.checkCarNameInput(carNameInput);

        List<String> carNames = getCarNames(carNameInput);
        InputValidator.checkCarName(carNames);

        return carNames;
    }

    private List<String> getCarNames(String carNameInput) {
        String[] split = carNameInput.split(",");
        return List.of(split);
    }

    private int enterTryNum() {
        GameInputView.printTryInputMessage();
        String tryNum = readLine();
        InputValidator.checkTryNum(tryNum);

        return Integer.parseInt(tryNum);
    }
}
