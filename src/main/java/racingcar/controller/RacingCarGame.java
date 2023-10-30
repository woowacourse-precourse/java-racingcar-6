package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarMovement;
import racingcar.model.WinnerDecision;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    public void runGame(){
        List<String> carNameList = InputView.inputCarName();

        int countNumber = InputView.inputCount();

        List<Car> carList = new ArrayList<>();
        for (String name : carNameList){
            carList.add(new Car(name));
        }

        OutputView.printResultMessage();
        for (int i = 0; i < countNumber; i++){
            race(carList);
            OutputView.printRoundResult(carList);
        }

        OutputView.printWinner(WinnerDecision.makeWinnerList(carList));

    }

    public void race(List<Car> carList){
        for (Car car : carList){
            CarMovement.moveCar(car);
        }
    }
}
