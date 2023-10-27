package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    InputProcessor inputProcessor;
    OutputProcessor outputProcessor;

    List<Car> cars;
    Integer repetition;

    public RacingCarGame() {
        cars = new ArrayList<>();
        inputProcessor = new InputProcessor();
        outputProcessor = new OutputProcessor();
    }

    public void run() {
        outputProcessor.printCarNameInputMessage();
        this.cars = inputProcessor.readCarNamesInput();
        outputProcessor.printRepetitionInputMessage();
        this.repetition = inputProcessor.readRepetitionInput();

        for (int repetitionCount = 0; repetitionCount < repetition; repetitionCount++) {
            processTurn();
            outputProcessor.printMoveResult(cars);
        }


    }

    private void processTurn() {
        cars.stream()
                .filter(t -> canMove())
                .forEach(Car::move);
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0,9) > 4;
    }
}
