package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNameValidator;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameController {

    List<String> carsName = new ArrayList<>();
    public void inputComputerName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();
        setInputCarName(inputCarName);
    }

    public void setInputCarName(String inputCarName) {
        CarNameValidator carNameValidator = new CarNameValidator();
        carsName = carNameValidator.validateInputCarName(inputCarName);
    }
}
