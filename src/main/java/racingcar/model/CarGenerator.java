package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class CarGenerator {
    private String userInput;
    public CarGenerator(String userInput) {
        this.userInput = userInput;
    }

    public List<String> generateCarNameList() {
        List<String> carNameList = Arrays.stream(userInput.split(",")).toList();
        InputValidator.validateDuplication(carNameList);
        InputValidator.validateEmptyName(carNameList);
        InputValidator.validateNameLength(carNameList);
        return carNameList;
    }

}
