package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarInput {
    public static List<String> inputCar() {
        String[] car = Console.readLine().split(",");
        ValidCheck.namesize_check(car);

        return new ArrayList<>(Arrays.asList(car));
    }

    public static int inputNumberOfMove(){
        String input = Console.readLine();
        ValidCheck.moveTypeCheck(input);

        return Integer.parseInt(input);
    }
}
