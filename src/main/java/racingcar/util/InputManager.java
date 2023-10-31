package racingcar.util;

import racingcar.domain.Car;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputManager {

    public static String[] getCarNames() {
        OutputManager.promptForCarNames();

        String carNameInput = Console.readLine();
        String[] carNames = carNameInput.split(",");

        ValidationManager.validateCarNames(carNames);

        return carNames;
    }

    public static int getTrials() {
        OutputManager.promptForTrials();
        String trialInput = Console.readLine();

        ValidationManager.validateTrials(trialInput);

        return Integer.parseInt(trialInput);
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
