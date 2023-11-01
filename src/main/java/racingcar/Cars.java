package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Cars {
    private final String[] carNames;

    public Cars() {
        String carNames = Console.readLine();
        this.carNames = carNames.split(",");
    }
    
}