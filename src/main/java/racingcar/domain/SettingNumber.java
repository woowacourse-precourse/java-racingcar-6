package racingcar.domain;

import racingcar.view.InputView;
import racingcar.service.SetNumberValidation;
public class SettingNumber {
    InputView inputView = new InputView();
    SetNumberValidation setNumberValidation = new SetNumberValidation();
    public int settingUserNumber(){
        String userInputNumber = inputView.setNumberInput();
        setNumberValidation.validateNumber(userInputNumber);
        return Integer.parseInt(userInputNumber);
    }
}
