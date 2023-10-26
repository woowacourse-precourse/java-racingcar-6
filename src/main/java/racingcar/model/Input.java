package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validator;

import java.util.Arrays;
import java.util.List;

public class Input {
    Validator validator = new Validator();

    public List<String> car() {
        String tempCar = Console.readLine();
        String[] splitCar = tempCar.split(",");
        List<String> carList = Arrays.asList(splitCar);
        validator.car(carList);
        return carList;
    }

    public int lap() {
        String tempLap = Console.readLine();
        validator.lap(tempLap);
        return Integer.parseInt(tempLap);
    }
}
