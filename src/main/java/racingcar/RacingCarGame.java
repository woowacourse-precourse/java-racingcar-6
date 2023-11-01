package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final RacingCarInput racingCarInput;
    private final RacingCarOutput racingCarOutput;
    private final RacingCars racingCars;

    public RacingCarGame() {
        this.racingCars = new RacingCars();
        this.racingCarInput = new RacingCarInput();
        this.racingCarOutput = new RacingCarOutput();
    }

    public void play(){
        racingCarOutput.printCarNameInput();
        List<String> nameList = racingCarInput.getCarNameInput();

        for (String carName : nameList) {
            racingCars.addRacingCar(carName);
        }

        racingCarOutput.printUserInput();;
        int times = racingCarInput.getUserInput();

        racingCarOutput.printResult();
        for (int i = 0; i < times; i++) {
            step();
        }
    }

    public void step(){
        racingCars.moveRacingCars();
        racingCarOutput.printStep(racingCars);
    }
}
