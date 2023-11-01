package racingcar.controller;

import racingcar.View.input.InputView;
import racingcar.View.output.OutPutView;
import racingcar.dto.MidGameResultDto;
import racingcar.model.RacingGame;
import racingcar.model.RacingCar;
import racingcar.service.RacingGameService;

import java.util.ArrayList;

public class RacingGameController {
    RacingGameService racingGameService = new RacingGameService();
    InputView inputView = new InputView();
    OutPutView outPutView = new OutPutView();

    public void start() {
        RacingGame racingGame = settingRacingGame();
        startRacingGame(racingGame);
        finishRacingGame();
    }

    private RacingGame settingRacingGame() {
        String userEnteredApplicantCarList = inputView.enterCarName();
        racingGameService.validateUserInputApplicant(userEnteredApplicantCarList);
        int userEnteredRaceCount = Integer.parseInt(inputView.enterRaceCount());
        racingGameService.validateUserInputRaceCount(userEnteredRaceCount);
        return racingGameService.createRacingGame(userEnteredApplicantCarList, userEnteredRaceCount);
    }

    private void startRacingGame(RacingGame racingGame) {
        outPutView.resultAnnouncementMessage();
        for (int i = 0; i < racingGame.getRaceCount(); i++) {
            ArrayList<MidGameResultDto> midGameResultDtoList = racingGameService.gameInProcess();
            outPutView.midGameResultMessage(midGameResultDtoList);
            System.out.println();
        }
    }

    private void finishRacingGame() {
        ArrayList<RacingCar> winnerNameList = racingGameService.findWinnerByMaxDistance();
        outPutView.FinalWinnerAnnouncementMessage(winnerNameList);
    }
}