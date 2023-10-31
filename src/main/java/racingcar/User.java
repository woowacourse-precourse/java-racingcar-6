package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private final Validator validator;

    public User() {
        validator = new Validator();
    }

    public List<String> createCarNames(String input) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        validator.validateInput(input);
        String[] inputCarNames = split(input);
        return toList(inputCarNames);
    }

    public int createMovingNumber(String input) {
        System.out.println("시도할 회수는 몇회인가요?");
        return toInt(input);
    }

    public String input() {
        return Console.readLine();
    }

    private String[] split(String carName) {
        return carName.split(",");
    }

    private List<String> toList(String[] inputCarNames) {
        List<String> carNames = new ArrayList<>(Arrays.asList(inputCarNames));
        validator.validateCarNames(carNames);
        return carNames;
    }

    private int toInt(String input) {
        System.out.println();
        validator.validateMovingNumber(input);
        return Integer.parseInt(input);
    }
}