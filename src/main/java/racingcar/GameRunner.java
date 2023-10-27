package racingcar;

import racingcar.dto.InputDTO;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameRunner {

    public static void playRacing() {
        InputDTO inputDTO = InputView.readUserInput();

        String[] names = inputDTO.names();
        Cars cars = Cars.createCars(names);

        int trialCount = inputDTO.trialCount();
        executeRacing(trialCount,  cars);
    }

    private static void executeRacing(int trialCount, Cars cars) {
        for (int i = 0; i < trialCount; i++) {
            cars.moveCars();
            OutputView.printRacingStatus(cars.fetchRacingStatus());
        }
    }
}
