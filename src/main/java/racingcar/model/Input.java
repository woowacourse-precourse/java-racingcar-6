package racingcar.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    List<String> carName = new ArrayList<>();

    public void car() {
        String tempCar = Console.readLine();
    }

    public void time() {
        String tempTime = Console.readLine();
    }
}
