package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class CarNameInput {
    private final static String SPLIT_SYMBOL = ",";
    public String[] returnCarName() {
        return Console.readLine().split(SPLIT_SYMBOL);
    }
}
