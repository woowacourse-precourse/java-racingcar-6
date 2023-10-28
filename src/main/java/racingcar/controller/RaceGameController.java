package racingcar.controller;

import racingcar.Car;
import racingcar.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RaceGameController {

    InputView input = new InputView();
    OutputView output = new OutputView();
    List<Car> carList = new ArrayList<>();
    Winner winner = new Winner();

    int numberOfAttempts=0;

    public void newGame(){
        output.gameStartMessage();
        String[] cars = input.getCarNames();
        setCarList(cars);

        output.getAttemptsMessage();
        numberOfAttempts = input.getNumberOfAttempts();
        output.gameResultMessage();
        for(int i=0; i<numberOfAttempts; i++){
            tryAllCarsOneStep();
            output.printGameResult(carList);
        }
        output.printWinner(winner.setWinnerList(carList));
    }

    private void tryAllCarsOneStep() {
        for(Car car : carList){
            car.tryOneStep();
        }
    }

    private void setCarList(String[] cars) {
        for(String car : cars){
            Car newCar = new Car(car);
            carList.add(newCar);
        }
    }


}
