package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class RacingCar {
    public String input(){
        return Console.readLine();
    }

    public List<String> naming(String input) {
        nullInput(input);
        String[] carList = input.split(",");
        List<String> racers = Arrays.asList(carList);
        return racers;
    }

    public void nullInput(String input) {
        if (input == null || input == "") {
            throw new IllegalArgumentException();
        }

    }



}
