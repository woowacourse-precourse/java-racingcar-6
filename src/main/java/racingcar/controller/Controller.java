package racingcar.controller;

import racingcar.model.CarInfoList;
import racingcar.model.RandomNumber;
import racingcar.model.UserRepetition;
import racingcar.view.OutputView;
import racingcar.view.UserInputView;

public class Controller {

    public static void gameEngine() {
        CarInfoList carInfoList = new CarInfoList(UserInputView.getCarNameInput());
        UserRepetition userRepetition = new UserRepetition(UserInputView.getRepetitionInput());
        while (!userRepetition.isRepetitionEnd()) {
            RandomNumber randomNumber = new RandomNumber(carInfoList.getCarNums());
            carInfoList.updateCarInfoList(randomNumber.getRandomNumberList());
            userRepetition.addNowRepeat();
        }
        OutputView.printCarNameNPosition(carInfoList.getCarNameList(), carInfoList.getCarPositionList());
        OutputView.printWinnerNameList(carInfoList.getWinnerList());
    }

}
