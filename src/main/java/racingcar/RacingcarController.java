package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingcarController {
    Input input = new Input();
    Cars cars = new Cars();

    public void playRacingcarGame() {
        inputCarsName();
    }

    private void inputCarsName() {
        String carsName = input.inputCarName();
    }
}
