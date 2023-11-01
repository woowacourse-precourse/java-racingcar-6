package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private static final String CARNAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CARMOVING_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    private final Validator validator;

    public User() {
        validator = new Validator();
    }

    public List<String> createCarNames(String input) {
        String[] inputCarNames = split(input);
        return toList(inputCarNames);
    }

    public int createMovingNumber(String input) {
        return toInt(input);
    }

    public String inputCarName() {
        System.out.println(CARNAMES_INPUT_MESSAGE);
        String inputCarNames = Console.readLine();
        validator.validateInput(inputCarNames);
        return inputCarNames;
    }

    public String inputNumber() {
        System.out.println(CARMOVING_INPUT_MESSAGE);
        String inputMovings = Console.readLine();
        validator.validateMovingNumber(inputMovings);
        return inputMovings;
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
        return Integer.parseInt(input);
    }
}