package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class RacingCar {
    ExceptionCase exception = new ExceptionCase();
    public String nameInput(){
        return Console.readLine();
    }

    public List<String> naming(String input) {
        exception.nullInput(input);
        exception.inputLength(input);

        String[] carList = input.split(",");
        List<String> racers = Arrays.asList(carList);
        return racers;
    }

    public int attemptInput() {
        String attempt = Console.readLine();
        return Integer.parseInt(attempt);
    }

}
