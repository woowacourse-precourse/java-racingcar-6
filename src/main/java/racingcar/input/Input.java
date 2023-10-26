package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
    private final String INPUT_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public void printInputCarsMessage() {
        System.out.println(INPUT_CARS_MESSAGE);
    }

    private String inputCarsName() {
        return Console.readLine();
    }

    public List<String> parsedCarsName(String inputValue) {
        List<String> cars = new ArrayList<>();
        return cars = Arrays.asList(inputValue.split(","));
    }

    public boolean isValidCarNameLength(List<String> cars) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
}
