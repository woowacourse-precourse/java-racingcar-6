package racingcar.manager;

import racingcar.dto.GameResultDto;
import racingcar.dto.GameSettingDto;
import racingcar.dto.RoundResultDto;
import racingcar.io.InputManager;
import racingcar.io.OutputManager;
import racingcar.domain.RacingCarGame;
import racingcar.utils.StringSplitter;
import racingcar.utils.generator.NumberGenerator;
import racingcar.utils.generator.RandomNumberGenerator;

import java.util.List;

public class GameManager {
    private final InputManager inputManager;
    private final OutputManager outputManager;
    private final NumberGenerator numberGenerator;
    private final RacingCarGame racingCarGame;
    private static final String SPLIT_DELIMITER = ",";

    public GameManager(InputManager inputManager, OutputManager outputManager, NumberGenerator numberGenerator) {
        this.inputManager = inputManager;
        this.outputManager = outputManager;
        this.numberGenerator = numberGenerator;
        this.racingCarGame = new RacingCarGame(numberGenerator);
    }

    public void startGame() {
        GameSettingDto gameSetting = inputGameSettings();

        racingCarGame.initialize(gameSetting);
        outputManager.printLine();
        outputManager.printExecutionResultMessage();

        for (int i = 0; i < gameSetting.getTryCount(); i++) {
            RoundResultDto roundResult = racingCarGame.playRound();
            outputManager.printRoundResult(roundResult);
            outputManager.printLine();
        }

        GameResultDto gameResult = racingCarGame.getWinners();
        outputManager.printFinalWinner(gameResult);
    }

    private GameSettingDto inputGameSettings() {
        List<String> carNames = inputCarNames();
        int tries = inputTries();
        return new GameSettingDto(carNames, tries);
    }

    private List<String> inputCarNames() {
        String carNamesString = inputManager.readCarNameInput();
        return StringSplitter.split(carNamesString, SPLIT_DELIMITER);
    }

    private int inputTries() {
        return Integer.parseInt(inputManager.readTryCountInput());
    }
}
