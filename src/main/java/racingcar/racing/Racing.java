package racingcar.racing;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingCarDrivers;
import racingcar.domain.round.Round;
import racingcar.service.RacingCarService;
import racingcar.view.View;

public class Racing {

    private final View view = new View();
    private final RacingCarService racingCarService = new RacingCarService();
    private String[] drivers;
    private int round;

    public void playRacing() {
        injectionInfo();
        startRacing();
        finishRacing();
    }

    public void injectionInfo() {
        drivers = new RacingCarDrivers(view.driverInjectionView()).getRacingCarDriversArray();
        round = new Round(view.roundInjectionView()).getRound();
        Console.close();
    }

    public void startRacing() {
        racingCarService.createCars(drivers);
        runRacingDuringRounds(round);
    }

    public void runRacingDuringRounds(int roundCount) {
        view.roundResultTitleView();
        for (int i = 0; i < roundCount; i++) {
            racingCarService.updateRacingResult();
            view.roundResultView(racingCarService.getRoundResults());
        }
    }

    public void finishRacing() {
        view.championView(racingCarService.getChampionResult());
    }
}