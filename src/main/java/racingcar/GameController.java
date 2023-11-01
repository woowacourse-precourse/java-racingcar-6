package racingcar;

import java.util.ArrayList;

public class GameController {
    private final int START = 0;
    private int executionTime;
    Car car = new Car();
    RandomNumber randomNumber = new RandomNumber();
    InputData inputData = new InputData();
    OutputGame outputGame = new OutputGame();

    public void startGame() {
        initializeGame();
    }

    private void initializeGame() {
        car.initializeCar();;
        inputData.inputExecutionTime();
        executionTime = inputData.returnExecutionTime();

        outputGame.printGame();
        for (int time = START; time < executionTime; time++) {
            moveCarByTime();
            outputGame.printRacing(car.getCarName(), car.getCarPosition());
        }
        displayResult();


    }


}
