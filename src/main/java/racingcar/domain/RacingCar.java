package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCar {
    ExceptionCase exception = new ExceptionCase();
    public String nameInput(){
        return Console.readLine();
    }

    public List<String> naming(String input) {
        exception.nullInput(input);

        String[] carList = input.split(",");
        List<String> cars = Arrays.asList(carList);
        exception.carNameLength(cars);

        return cars;
    }

    public int attemptInput() {
        String attempt = Console.readLine();
        return Integer.parseInt(attempt);
    }

}
