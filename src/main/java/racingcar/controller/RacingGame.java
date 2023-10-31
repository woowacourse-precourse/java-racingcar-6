package racingcar.controller;

import racingcar.enums.GameSettingType;
import racingcar.service.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class RacingGame implements Game {
    private final Referee referee;
    public RacingGame() {
        referee = new Referee(collectGameSettingInfos());
    }

    @Override
    public void run() {
        playRacingGame();
        announceWinners();
    }

    private Map<GameSettingType,String> collectGameSettingInfos() {
        Map<GameSettingType, String> gameSettingInfo = new EnumMap<>(GameSettingType.class);
        gameSettingInfo.put(GameSettingType.CAR_NAMES, collectCarNames());
        gameSettingInfo.put(GameSettingType.ATTEMPTS, collectNumberOfAttempts());
        return gameSettingInfo;
    }

    private String collectCarNames() {
        OutputView.printCarNameInputMessage();
        return InputView.carNamesInput();
    }

    private String collectNumberOfAttempts() {
        OutputView.printNumberOfAttemptsInputMessage();
        return InputView.numberOfAttemptsInput();
    }

    private void playRacingGame() {
        OutputView.printPlayResultMessage();
        while (!referee.anyCarReaches()) {
            referee.getCars().everyCarMoveForward();
            OutputView.printPlayResult(referee.getPlayResults());
        }
    }

    private void announceWinners() {
        OutputView.printWinners(referee.getWinnersNames());
    }
}
