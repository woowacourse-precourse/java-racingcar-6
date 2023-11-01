package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private final OutView outView = new OutView();
    private final InputView inputView = new InputView();

    public void run() {
        // 출전할 레이싱카를 입력받을 안내문을 출력한다.
        outView.printInputRacingCar();

        // 출전할 레이싱카를 입력받는다.
        String nameOfCars = Console.readLine();
        RacingCars racingCars = inputView.inputNameOfRacingCars(nameOfCars);

        // 시도할 횟수를 입력받는다.

        // 게임을 시작한다. (로직을 진행한다)

        // 게임결과 출력한다.
    }
}
