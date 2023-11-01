package racingcar;

import java.util.ArrayList;

public class GameController {
    private final int START = 0;
    private int executionTime;
    Car car = new Car();
    RandomNumber randomNumber = new RandomNumber();
    InputView inputView = new InputView();
    OutputGame outputGame = new OutputGame();

    public void startGame() {
        initializeGame();
    }

    private void initializeGame() {
        car.initializeCar();
        ;
        inputView.inputExecutionTime();
        executionTime = inputView.returnExecutionTime();

        outputGame.printGame();
        for (int time = START; time < executionTime; time++) {
            moveCarByTime();
            outputGame.printRacing(car.getCarName(), car.getCarPosition());
        }
        displayResult();

    }

    private void moveCarByTime() {
        int carCount = car.getCarCount();
        ArrayList<String> carName = car.getCarName();
        for (int carIndex = START; carIndex < carCount; carIndex++) {
            car.updateCarPosition(carName.get(carIndex), randomNumber.getMovement());
        }
    }

    private void displayResult() {
        outputGame.printWinner(car.getWinner());
    }


}
