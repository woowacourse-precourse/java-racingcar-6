package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
    Validator validator = new Validator();
    List<String> carList = new ArrayList<>();

    public void car() {
        String tempCar = Console.readLine();
        String[] splitCar = tempCar.split(",");
        carList = Arrays.asList(splitCar);
        validator.car(carList);
    }

    public void lap() {
        String tempTime = Console.readLine();
    }
}
