package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarNameScanService {
    private String racingCarNames = null;
    public void readRacingCarNames() {
        racingCarNames = Console.readLine();
    }

    public String getRacingCarNames() {
        return racingCarNames;
    }

}
