package racingcar.controller;

import racingcar.model.CarInfoList;
import racingcar.model.RandomNumber;
import racingcar.model.RaceRepetition;
import racingcar.view.OutputView;
import racingcar.view.UserInputView;

public class Controller {

    public static void gameEngine() {
        CarInfoList carInfoList = new CarInfoList(UserInputView.getCarNameInput());
        RaceRepetition raceRepetition = new RaceRepetition(UserInputView.getRepetitionInput());
        while (!raceRepetition.isRepetitionEnd()) {
            RandomNumber randomNumber = new RandomNumber(carInfoList.getCarNums());
            carInfoList.updateCarInfoList(randomNumber.getRandomNumberList());
            if (raceRepetition.isFirstRepetition()) { OutputView.printFirstSeparator(); }
            OutputView.printCarNameNPosition(carInfoList.getCarNameList(), carInfoList.getCarPositionList());
            raceRepetition.addNowRepeat();
        }
        OutputView.printWinnerNameList(carInfoList.getWinnerList());
    }

}
