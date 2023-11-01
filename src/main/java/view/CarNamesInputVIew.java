package view;

import camp.nextstep.edu.missionutils.Console;
import validator.CarNameInputValidator;

import java.util.Arrays;

public class CarNamesInputVIew {
    CarNameInputValidator carNameInputValidator = new CarNameInputValidator();
    public String[] receiveCarNames() {
        String carNamesInput = Console.readLine();
        String[] carNames = carNamesInput.split(",");
        carNameInputValidator.validCarNames(carNames);
        return carNames;
    }
}
