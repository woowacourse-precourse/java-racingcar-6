package racingcar;

import racingcar.machine.RacingCarMachine;
import racingcar.machine.RacingCarMachineInterface;
import racingcar.machine.ui.RacingCarMachineConsoleUI;
import racingcar.machine.ui.RacingCarMachineUI;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        RacingCarMachineUI ui = new RacingCarMachineConsoleUI();
        RacingCarMachineInterface machine = new RacingCarMachine(ui);

        machine.createCar();
        machine.attemptToMoveCars();
        machine.showWinner();
    }
}
