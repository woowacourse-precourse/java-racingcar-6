package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class CarNameInput {

    private String[] returnCarName() {
        return Console.readLine().split(",");
    }
}
