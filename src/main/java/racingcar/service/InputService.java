package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.utils.InputValidatorUtils;

import java.util.List;

public class InputService {
    private InputValidatorUtils inputValidatorUtils;

    public InputService() {
        this.inputValidatorUtils = new InputValidatorUtils();
    }

    public void readCarInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> cars = List.of(input.split(","));
        if (inputValidatorUtils.isValidateCarInput(cars)) {
            System.out.println(cars);
        } else {
            throw new IllegalArgumentException();
        }

    }
}
