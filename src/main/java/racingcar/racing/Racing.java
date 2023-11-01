package racingcar.racing;

import racingcar.domain.GameInfo;
import racingcar.service.RacingCarService;
import racingcar.view.View;

public class Racing {

    private final View view = new View();
    private final RacingCarService racingCarService = new RacingCarService();
    private GameInfo gameInfo;


    public void racingConfig() {
        String driverNames = view.driverInjectionView();
        String roundNumber = view.roundInjectionView();
        gameInfo = new GameInfo(driverNames, roundNumber);
        racingCarService.createCars(gameInfo.getRacingCarDrivers());
    }

    public void startRacing() {
        racingConfig();
        runRacingDuringRounds();
        finishRacing();
    }

    public void runRacingDuringRounds() {
        for (int i = 0; i < gameInfo.getRound(); i++) {
            racingCarService.updateRacingResult();
            view.roundResultView(racingCarService.getRoundResults());
        }
    }

    public void finishRacing() {
        view.championView(racingCarService.getChampionResult());
    }
}