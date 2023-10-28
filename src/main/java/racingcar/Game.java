package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final InputValidator inputValidator = new InputValidator();

    private final List<Car> cars = new ArrayList<>();

    public void start() {
        printMessage(START_MESSAGE);
        setCarNames();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void setCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            inputValidator.validCarNameLength(carName);
            cars.add(new Car(carName));
        }
    }
}
