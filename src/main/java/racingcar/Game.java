package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {
    private int playNum = 0;
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

        playNum = inputHandler.inputRacingNumber();

        racingStart();
    }


    private void createCars(String [] carNames) {
        for (String carName : carNames) {
            cars.add(carName);
        }
    }

    private void racingStart() {

    }

    private List<Integer> getMaxForwardCarsIndex() {
        return null;
    }
}
