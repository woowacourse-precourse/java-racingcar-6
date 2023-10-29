package racingcar.controller;

import racingcar.View.InputView;
import racingcar.View.OutPutView;
import racingcar.dto.GameResultDto;
import racingcar.model.RacingCar;
import racingcar.service.RacingGameService;
import racingcar.validation.ValidateInput;

import java.util.ArrayList;

public class RacingGameController {
    RacingGameService racingGameService = new RacingGameService();
    InputView inputView = new InputView();
    OutPutView outPutView = new OutPutView();

    public void start() {
        int raceCount = settingRacingGameAndGetRaceCount();
        startRacingGame(raceCount);
        finishRacingGame();
    }

    private int settingRacingGameAndGetRaceCount() {
        String userEnteredApplicantCarList = inputView.enterCarName();
        racingGameService.validateUserInputApplicant(userEnteredApplicantCarList);
        int userEnteredRaceCount = Integer.parseInt(inputView.enterRaceCount());
        racingGameService.validateUserInputInputRaceCount(userEnteredRaceCount);

        racingGameService.settingForRacingGame(userEnteredApplicantCarList, userEnteredRaceCount);
        return userEnteredRaceCount;
    }

    private void startRacingGame(int raceCount) {
        outPutView.resultAnnouncementMessage();
        for (int i = 0; i < raceCount; i++) {
            ArrayList<GameResultDto> gameResultDtoList = racingGameService.gameInProcess();
            outPutView.midGameResultMessage(gameResultDtoList);
            System.out.println();
        }
    }

    private void finishRacingGame() {
        ArrayList<RacingCar> winnerNameList = racingGameService.findWinnerByMaxDistance();
        outPutView.winnerAnnouncementMessage(winnerNameList);
    }
}