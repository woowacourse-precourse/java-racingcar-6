package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {
    private Validator validator;
    private List<String> carNames;

    public User() {
        validator = new Validator();
        carNames = new ArrayList<>();
    }

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validator.validateInput(input);

        String[] carNameArray = input.split(",");
        for (String carName : carNameArray) {
            carNames.add(carName);
        }
        validator.validateCarNames(carNames);

        return carNames;
    }

    public int inputMovingNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputMovingNumber = Console.readLine();
        validator.validateMovingNumber(inputMovingNumber);

        return Integer.parseInt(inputMovingNumber);
    }

}