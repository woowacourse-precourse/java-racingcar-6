package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputDataHandler {

    private String[] inputCarNames;

    public void getStringFromPlayer(){
        inputCarNames = Console.readLine().split(",");
    }
}
