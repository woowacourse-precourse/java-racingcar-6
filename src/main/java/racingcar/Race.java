package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private Integer gameCount;
    private final List<Car> cars = new ArrayList<>();

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputCarNames();
        inputGameCount();
    }

    private void inputCarNames() {
        String userInput = Console.readLine();
        String[] carNames = userInput.split(",");
        createCars(carNames);
    }

    private void createCars(String[] carNames) {
        for (String carName : carNames) {
            InputValidator inputValidator = new InputValidator();
            inputValidator.carNameLength(carName);
            cars.add(new Car(carName));
        }
    }

    private void inputGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String userInput = Console.readLine();
        saveGameCount(userInput);
        Console.close();
    }

    private void saveGameCount(String userInput) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.gameCountFormat(userInput);
        gameCount = Integer.parseInt(userInput);
    }
}
