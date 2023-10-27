package racingcar;

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
        this.cars = inputProcessor.getCarNameListInput();
        outputProcessor.printRepetitionInputMessage();
        this.repetition = inputProcessor.getRepetitionInput();
    }
}
