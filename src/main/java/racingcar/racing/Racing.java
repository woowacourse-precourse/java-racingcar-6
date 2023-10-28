package racingcar.racing;

import java.util.List;
import racingcar.RacingCars;
import racingcar.dto.input.InputDTO;
import racingcar.dto.output.CarInfo;
import racingcar.dto.output.WinnerInfo;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Racing {

    public static void playRacing() {
        InputDTO inputDTO = readInput();

        RacingCars racingCars = initRacingCars(inputDTO);

        executeRacing(inputDTO.trialCount(), racingCars);

        WinnerInfo winnerInfo = racingCars.getWinner();
        OutputView.printWinner(winnerInfo);
    }

    private static InputDTO readInput() {
        return InputView.readUserInput();
    }

    private static RacingCars initRacingCars(InputDTO inputDTO) {
        RandomGenerator randomGenerator = new NsRandomGenerator();
        MoveStrategy moveStrategy = new MoveStrategy(randomGenerator);

        return RacingCars.createCars(inputDTO.names(), moveStrategy);
    }

    private static void executeRacing(int trialCount, RacingCars racingCars) {
        for (int i = 0; i < trialCount; i++) {
            racingCars.move();

            List<CarInfo> results = racingCars.getRoundResults();
            OutputView.printRoundResult(results);
        }
    }
}
