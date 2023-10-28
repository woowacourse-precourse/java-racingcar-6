package racingcar;

import racingcar.dto.input.InputDTO;
import racingcar.racing.MoveStrategy;
import racingcar.racing.NsRandomGenerator;
import racingcar.racing.Racing;
import racingcar.racing.RandomGenerator;
import racingcar.view.InputView;

public class GameLauncher {
    public static void run() {
        Racing racing = createRacing();
        racing.playRacing();
    }

    private static Racing createRacing() {
        //사용자의 입력을 받는다.
        InputDTO inputDTO = InputView.readUserInput();

        // 이동 전략을 설정한다.
        RandomGenerator randomGenerator = new NsRandomGenerator();
        MoveStrategy moveStrategy = new MoveStrategy(randomGenerator);

        // RacingCars 객체를 생성한다.
        RacingCars racingCars = RacingCars.createCars(inputDTO.names(), moveStrategy);

        // Racing 객체를 생성해서 반환한다.
        return new Racing(inputDTO.trialCount(), racingCars);
    }
}
