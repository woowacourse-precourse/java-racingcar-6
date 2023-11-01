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

    public void startGame(){
        displayGameStartMessage();
        String[] cars = input.getCarNames();
        setCarList(cars);

        displayGetAttemptsMessage();
        int numberOfAttempts = input.getNumberOfAttempts();
        displayGameResultMessage();

        playGame(numberOfAttempts);

        displayWinner();
    }

    private void playGame(int numberOfAttempts) {
        for(int i = 0; i< numberOfAttempts; i++){
            tryAllCarsOneStep();
            output.printGameResult(carList);
        }
    }

    private void displayWinner() {
        output.printWinner(winner.setWinnerList(carList));
    }

    private void displayGetAttemptsMessage() {
        output.getAttemptsMessage();
    }

    private void displayGameStartMessage() {
        output.gameStartMessage();
    }

    private void displayGameResultMessage() {
        output.gameResultMessage();
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
