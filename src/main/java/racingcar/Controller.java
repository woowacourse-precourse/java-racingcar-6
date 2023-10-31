package racingcar;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
    private ArrayList<Car> racingCars = new ArrayList<>();

    public String[] nameInput() {
        String[] names = Console.readLine().split(",");

        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("Too long name");
            }
        }

        return names;
    }
}
