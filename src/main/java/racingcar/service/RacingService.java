package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.dto.RacingStatus;
import racingcar.util.RacingJudgment;
import racingcar.view.OutputHandler;

public class RacingService {

    RacingStatus status = new RacingStatus();
    RacingJudgment judgment = new RacingJudgment();

    public void initRacing(List<String> carNames, int numberOfAttempt) {
        status.setCarNames(carNames);
        status.setCarList();
        status.setNumberOfAttempt(numberOfAttempt);
    }

    public void startRacing() {
        int leftAttempt = status.getNumberOfAttempt();
        List<String> carNames = status.getCarNames();
        OutputHandler.printResult();
        while (leftAttempt > 0) {
            leftAttempt--;
            moveCarPosition();
            OutputHandler.printAttemptResult(status);
        }
    }
    
    public void endRacing(){
        OutputHandler.printWinner(judgment.findWinner(status));
    }

    private void moveCarPosition() {
        for (String carName : status.getCarNames()) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                status.moveCarPosition(carName);
            }
        }
    }
}
