package racingcar.user;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private String[] racingCarNames;
    private String inputRacingRound;

    public void settingRacingCarNames() {
        this.racingCarNames = Console.readLine().split(",");
    }
    public void settingRacingRound() {
        this.inputRacingRound = Console.readLine();
    }

    public String[] getRacingCarNames() {
        return racingCarNames;
    }

    public int getInputRacingRound() {
        return Integer.parseInt(inputRacingRound);
    }
}
