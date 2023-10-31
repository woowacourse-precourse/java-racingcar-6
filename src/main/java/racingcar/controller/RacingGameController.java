package racingcar.controller;

import racingcar.View.input.InputView;
import racingcar.View.output.OutPutView;
import racingcar.View.output.OutputFormatter;
import racingcar.dto.MidGameResultDto;
import racingcar.model.CarRacingGame;
import racingcar.model.RacingCar;
import racingcar.service.RacingGameService;

import java.util.ArrayList;

public class RacingGameController {
    RacingGameService racingGameService = new RacingGameService();
    InputView inputView = new InputView();
    OutPutView outPutView = new OutPutView();

    public void start() {
        CarRacingGame carRacingGame = settingRacingGame();
        startRacingGame(carRacingGame);
        finishRacingGame();
    }

    private CarRacingGame settingRacingGame() {
        String userEnteredApplicantCarList = inputView.enterCarName();
        racingGameService.validateUserInputApplicant(userEnteredApplicantCarList);
        int userEnteredRaceCount = Integer.parseInt(inputView.enterRaceCount());
        racingGameService.validateUserInputRaceCount(userEnteredRaceCount);
        return racingGameService.createRacingGame(userEnteredApplicantCarList, userEnteredRaceCount);
    }

    private void startRacingGame(CarRacingGame carRacingGame) {
        outPutView.resultAnnouncementMessage();
        for (int i = 0; i < carRacingGame.getRaceCount(); i++) {
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