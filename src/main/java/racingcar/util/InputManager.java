package racingcar.util;

import racingcar.domain.Car;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputManager {

    // ","로 구분된 이름을 String array로 입력받는 메서드
    public static String[] getCarNames() {
        OutputManager.promptForCarNames();

        String carNameInput = Console.readLine();
        String[] carNames = carNameInput.split(",");

        ValidationManager.validateCarNames(carNames);

        return carNames;
    }

    // 시도 횟수를 입력받고 검증 후 return 하는 메서드
    public static int getTrials() {
        OutputManager.promptForTrials();
        String trialInput = Console.readLine();

        ValidationManager.validateTrials(trialInput);

        return Integer.parseInt(trialInput);
    }

    // String array로 입력받은 자동차 이름을 List로 return하는 메서드
    public static List<Car> getCars() {
        String[] carNames = getCarNames();
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }

        return cars;
    }
}
