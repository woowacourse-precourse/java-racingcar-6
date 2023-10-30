package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputManager {

    public static String[] getCarNames() {
        OutputManager.promptForCarNames();

        String carNameInput = Console.readLine();

        return carNameInput.split(",");
    }

    public static int getTrials() {
        OutputManager.promptForTrials();
        return Integer.parseInt(Console.readLine());
    }

    public static List<Car> getCars() {
        String[] carNames = getCarNames();
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }

        return cars;
    }
}
