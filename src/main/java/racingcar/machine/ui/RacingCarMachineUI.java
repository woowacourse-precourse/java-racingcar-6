package racingcar.machine.ui;

import java.util.List;

public interface RacingCarMachineUI {
    void displayRequestCarNames();
    List<String> inputCarNames();
    void displayRequestNumberOfAttempts();
    int inputNumberOfAttempts();
    void displayRaceProgress(String carName, int position);
    void displayFinalWinner(List<String> winners);

}
