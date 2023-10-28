package racingcar;

import camp.nextstep.edu.missionutils.Console;
public class RacingInfo {
    private String[] names;

    public String[] getNames() {
        return names;
    }

    public void setNames() {
        names = Console.readLine().split(",");
    }
}
