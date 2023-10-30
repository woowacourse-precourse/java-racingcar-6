package racingcar.machine;

import racingcar.machine.ui.RacingCarMachineUI;

import java.util.List;

public class RacingCarMachine implements RacingCarMachineInterface{
    private final RacingCarMachineUI ui;

    public RacingCarMachine(RacingCarMachineUI ui) {
        this.ui = ui;
    }

    @Override
    public void createCar() {
        ui.displayRequestCarNames();
        System.out.println("ui.inputCarNames() = " + ui.inputCarNames());
    }

    @Override
    public void attemptToMoveCars() {
        ui.displayRequestNumberOfAttempts();
        System.out.println("ui.inputNumberOfAttempts() = " + ui.inputNumberOfAttempts());

        ui.displayRaceProgress("testingCarName1", 3);
        ui.displayRaceProgress("testingCarName2", 2);
        ui.displayRaceProgress("testingCarName3", 8);

    }

    @Override
    public void showWinner(){
        ui.displayFinalWinner(List.of("test1", "test2", "test3"));
    }
}
