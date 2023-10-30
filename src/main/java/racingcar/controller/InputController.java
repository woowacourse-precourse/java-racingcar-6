package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Cars;

import java.util.Arrays;

public class InputController {
    public Cars getCarNameFromUserInput(){
        String input = Console.readLine();
        return new Cars(Arrays.asList(input.split(",")));
    }
}
