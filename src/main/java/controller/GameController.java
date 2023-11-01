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
        Validator.nameValidator(nameList);
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
        System.out.println("실행 결과");
        for (int i = 0; i < this.gameTimes; i++) {
            for (Car car : this.carList) {
                car.moveCar();
            }
            OutputView.printProceeding(this.carList);
        }
    }

    public void gameEnding() {
        List<Car> winnerList = new ArrayList<>();
        Car firstCar = this.carList.get(0);
        winnerList.add(firstCar);
        for (int i = 1; i < this.carList.size(); i++) {
            Car winnerCar = winnerList.get(0);
            Car otherCar = this.carList.get(i);

            int winnerLocation = winnerCar.getLocation();
            int otherCarLocation = otherCar.getLocation();

            if (winnerLocation < otherCarLocation) {
                winnerList.clear();
                winnerList.add(otherCar);
            } else if (winnerLocation == otherCarLocation) {
                winnerList.add(otherCar);
            }
        }

        OutputView.printResult(winnerList);
    }
}
