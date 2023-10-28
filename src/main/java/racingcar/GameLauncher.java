package racingcar;

import racingcar.domain.RacingCars;
import racingcar.dto.input.InputDTO;
import racingcar.common.strategy.MoveStrategy;
import racingcar.common.generator.NsRandomGenerator;
import racingcar.controller.Racing;
import racingcar.common.generator.RandomGenerator;
import racingcar.view.InputView;

public class GameLauncher {
    public static void run() {
        InputDTO inputDTO = getInputFromUser();
        Racing racing = createRacing(inputDTO);
        racing.startRacing();
    }

    private static InputDTO getInputFromUser() {
        return InputView.readUserInput();
    }

    private static Racing createRacing(InputDTO inputDTO) {
        RandomGenerator randomGenerator = new NsRandomGenerator();
        MoveStrategy moveStrategy = new MoveStrategy(randomGenerator);
        RacingCars racingCars = RacingCars.createCars(inputDTO.names(), moveStrategy);
        return new Racing(inputDTO.trialCount(), racingCars);
    }
}
