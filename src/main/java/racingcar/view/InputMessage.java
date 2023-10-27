package racingcar.view;

import racingcar.model.MessageEnum;

public class InputMessage {
    public void inputCarNameMessage(){
        System.out.println(MessageEnum.INPUT_CAR_NAME_MESSAGE.getMessage());
    }

    public void inputTryNumberMessage(){
        System.out.println(MessageEnum.INPUT_TRY_NUMBER_MESSAGE.getMessage());
    }
}
