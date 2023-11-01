package controller;

import java.util.ArrayList;
import java.util.List;
import model.Car;
import util.ReformatHandler;
import util.Validator;
import view.InputView;
import view.OutputView;

public class GameController {

    ArrayList<Car> carList = new ArrayList<>();
    int gameTimes = 0;

    public void startGame() {
        String nameListString = InputView.enterCarNames();
        List<String> nameList = ReformatHandler.nameListDivider(nameListString);
        for (String name : nameList) {
            this.carList.add(new Car(name));
        }
    }

    public void numberOfGame() {
        String gameTimeString = InputView.enterMatchTimes();
        boolean isNumber = Validator.isNumberValidator(gameTimeString);
        if (isNumber) {
            this.gameTimes = ReformatHandler.stringToNum(gameTimeString);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void proceedingGame() {
        for (int i = 0; i < this.gameTimes; i++) {
            for (Car car : this.carList) {
                car.moveCar();
            }
            OutputView.printProceeding(this.carList);
        }
    }

}
