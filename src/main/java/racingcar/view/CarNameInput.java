package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class CarNameInput {

    public String[] returnCarName() {
        return Console.readLine().split(",");
    }
}
