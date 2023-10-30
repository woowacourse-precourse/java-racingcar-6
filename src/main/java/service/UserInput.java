package service;

import static service.Validation.CarNames;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;


public class UserInput {

    public static void CarNames(){
        String input = Console.readLine();

        Stream<String> carNames = Arrays.stream(input.split(","));
        carNames.forEach(Validation::CarNames);

    }

}
