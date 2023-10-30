package racingcar.Model;

import java.util.Arrays;
import java.util.List;
import racingcar.Validator.CarNameInputValidator;
import racingcar.Validator.TurnNumInputValidator;
import racingcar.View.UserInputView;

public class UserInput {
    UserInputView userInputView = new UserInputView();
    CarNameInputValidator carNameInputValidator = new CarNameInputValidator();
    TurnNumInputValidator turnNumInputValidator = new TurnNumInputValidator();

    public List<String> carNameList;
    public Integer turnNumInteger;


    public UserInput() {
        this.carNameList = initCarNameList();
        this.turnNumInteger = initTurnNumInteger();
    }

    public List<String> initCarNameList() {
        String carNameInput = userInputView.setInputCarName();
        carNameInputValidator.validate(carNameInput);

        return Arrays.asList(carNameInput.split(","));
    }

    public Integer initTurnNumInteger() {
        String turnNumInput = userInputView.setInputTurnNumber();
        turnNumInputValidator.validate(turnNumInput);

        return Integer.parseInt(turnNumInput);
    }


}
