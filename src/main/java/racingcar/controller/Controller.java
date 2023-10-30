package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Model;
import racingcar.utility.Utility;
import racingcar.varification.Varification;
import racingcar.view.View;

public class Controller {
    public Controller() {
        Model model = new Model();
        Utility utility = new Utility();
        Varification varification = new Varification();
        View view = new View();

        String carNames = view.getCarNames();
        String[] carNameArray = utility.splitStringToArray(carNames);
        varification.checkNameLength(carNameArray);
        List<Car> carList = model.makeCarList(carNameArray);

        String stringOfTimes = view.getStringOfTimes();
        varification.checkStringIsNum(stringOfTimes);
        int intOfTimes = utility.makeStringToInt(stringOfTimes);

        for(int i = 0 ; i < intOfTimes ; i++) {
            model.racingForOneTurn(carList);
            view.printResult(carList);
        }

        List<String> winnerList = model.getWinnerList(carList);
        view.printWinner(winnerList);
    }
}
