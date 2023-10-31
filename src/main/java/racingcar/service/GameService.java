package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.RaceCount;
import racingcar.domain.RaceResult;
import racingcar.domain.WinnerData;

public class GameService {
    static public void initializeCars(String inputCarNames) {
        Cars.initializeByInput(inputCarNames);
    }

    static public void initializeRaceCount(String inputRaceCount) {
        RaceCount.initializeByInput(inputRaceCount);
    }

    static public boolean isAllRaceDone() {
        return RaceCount.equalsTotal();
    }

    static public String runSingleRace() {
        RaceResult raceResult = Cars.runSingleRace();
        RaceCount.up();
        return raceResult.toString();
    }

    static public String getWinnerNames() {
        WinnerData winnerData = Cars.pickWinners();
        return winnerData.concatWinnerNames();
    }
}
