package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.RaceCount;
import racingcar.domain.WinnerData;

public class GameService {

    private Cars getCars() {
        return Cars.getInstance();
    }

    public void initCarsFromInput(String inputCarNames) {
        getCars().addCarsFromInput(inputCarNames);
    }

    private RaceCount getRaceCount() {
        return RaceCount.getInstance();
    }

    public void initRaceCountFromInput(String inputRaceCount) {
        getRaceCount().initTotalCountFromInput(inputRaceCount);
    }

    public boolean isAllRaceDone() {
        return getRaceCount().equalsTotal();
    }

    public String runSingleRace() {
        String raceResult = getCars().runSingleRace();
        getRaceCount().up();
        return raceResult;
    }

    public String getWinnerNames() {
        WinnerData winnerData = getCars().pickWinners();
        return winnerData.concatWinnerNames();
    }
}
