package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public Player() {
    }

    private String inputCarName(){
        String carName= Console.readLine();
        checkInputFormat(carName);
        return carName;
    }
}
