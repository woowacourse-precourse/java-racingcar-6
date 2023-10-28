package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Input {


    public static List<String> inputCarName(){
        String userInput = Console.readLine();
        List<String> cars = new ArrayList<>();

        for (String car : userInput.split(",")) {
            cars.add(car);
        }

        return cars;
    }
}
