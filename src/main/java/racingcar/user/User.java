package racingcar.user;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private String[] racingCarNames;
    private String inputRacingCount;

    public void settingRacingCarNames() {
        this.racingCarNames = Console.readLine().split(",");
    }
    public void settingRacingCount() {
        this.inputRacingCount = Console.readLine();
    }

    public String[] getRacingCarNames() {
        return racingCarNames;
    }

    public int getInputRacingCount() {
        return Integer.parseInt(inputRacingCount);
    }
}
