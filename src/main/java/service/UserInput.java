package service;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Arrays;


public class UserInput {

    public static void CarNames(){
        String input = Console.readLine();

        List<String> carNames = Arrays.stream(input.split(","))
                                .toList();

    }

}
