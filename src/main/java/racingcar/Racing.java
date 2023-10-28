package racingcar;

import java.util.List;
import racingcar.dto.input.InputDTO;
import racingcar.dto.output.RoundResultDTO;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Racing {

    public static void playRacing() {
        InputDTO inputDTO = InputView.readUserInput();

        String[] names = inputDTO.names();
        RacingCars racingCars = RacingCars.createCars(names);

        int trialCount = inputDTO.trialCount();
        executeRacing(trialCount, racingCars);
    }

    private static void executeRacing(int trialCount, RacingCars racingCars) {
        for (int i = 0; i < trialCount; i++) {
            racingCars.move();

            List<RoundResultDTO> results = racingCars.getRoundResults();
            OutputView.printRoundResult(results);
        }
    }
}
