package racingcar.utill;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.iosystem.InputView;
import racingcar.iosystem.OutputView;

import java.util.Arrays;

public class RacingGame {
    public RacingGame() {
        // 대충 게임실행 넣으면 될듯
        InputView inputView = new InputView(InputView
                .setCarsName(InputView
                        .inputCar()));
        run(inputView);
        OutputView.endGameResult(inputView.getCarMove(), inputView.getCars());
    }


    public void run(InputView inputView) {
        for (int i = 0; i < inputView.getTryCnt(); i++) {
            runMoveCar(inputView.getCars(), inputView.getCarMove());
            OutputView.printExecutionResult(inputView.getCars(), inputView.getCarMove());
            System.out.println();
        }
    }

    public void runMoveCar(String[] cars, int[] carMove) {
        for (int i = 0; i < cars.length; i++) {
            if (randomMove()) {
                carMove[i] ++;
            }
        }
    }

    public boolean randomMove() {
        int randomInt = Randoms.pickNumberInRange(0,9);
        if (randomInt >= 4 ) {
            return true;
        }
        return false;
    }
}

