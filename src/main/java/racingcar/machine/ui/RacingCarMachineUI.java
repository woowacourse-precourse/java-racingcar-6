package racingcar.machine.ui;

import racingcar.machine.car.CarInterface;

import java.util.List;

public interface RacingCarMachineUI {
    void displayRequestCarNames();
    List<String> inputCarNames();
    void displayRequestNumberOfAttempts();
    int inputNumberOfAttempts();

    void displayRaceResult();

    void displayRaceProgress(List<CarInterface> cars);
    void displayFinalWinner(String winners);

}
