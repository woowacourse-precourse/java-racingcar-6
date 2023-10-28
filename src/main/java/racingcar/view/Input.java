package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {


    public static List<String> inputCarName() {
        String userInput = Console.readLine();
        List<String> cars = new ArrayList<>();

        for (String car : userInput.split(",")) {
            cars.add(car);
        }

        return cars;
    }

    public static String inputNumberMove() {
        return Console.readLine();
    }
}
