package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Model;
import racingcar.utility.Utility;
import racingcar.varification.Varification;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    public Controller() {
        Model model = new Model();
        Utility utility = new Utility();
        Varification varification = new Varification();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String carNames = inputView.getCarNames();
        String[] carNameArray = utility.splitStringToArray(carNames);
        varification.checkNameLength(carNameArray);
        List<Car> carList = model.makeCarList(carNameArray);

        String stringOfTimes = inputView.getStringOfTimes();
        varification.checkStringIsNum(stringOfTimes);
        int intOfTimes = utility.makeStringToInt(stringOfTimes);

        for(int i = 0 ; i < intOfTimes ; i++) {
            model.racingForOneTurn(carList);
            outputView.printResult(carList);
        }

        List<String> winnerList = model.getWinnerList(carList);
        outputView.printWinner(winnerList);
    }
}
