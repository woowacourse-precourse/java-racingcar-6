package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Cars cars;

    public Game() {
        cars = new Cars();
    }

    public void start() {
        UserInputHandler inputHandler = new UserInputHandler();

        String[] carNames = inputHandler.inputNames();

        if(!ExceptionInput.checkNameLength(carNames)) {
            throw new IllegalArgumentException();
        }
        createCars(carNames);

        int playNum = inputHandler.inputRacingNumber();

        System.out.println(Constants.PRINT_GROUND_RESULT);

        for(int i=0;i<playNum;i++) {
            cars.racing();
            cars.printRoundRacingResult();
        }

        printFinalResult(cars.getFinalWinners());
    }


    private void createCars(String [] carNames) {
        for (String carName : carNames) {
            cars.add(carName);
        }
    }

    private void printFinalResult(ArrayList<String> winners) {
        System.out.println(Constants.PRINT_FINAL_RESULT +
                String.join(", " , winners));
    }
}
