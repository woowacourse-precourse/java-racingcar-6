package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.iosystem.InputView;
import racingcar.iosystem.OutputView;

public class RunGame {

    public static void run(InputView inputView) {
        for (int i = 0; i < inputView.getTryCnt(); i++) {
            runMoveCar(inputView.getCars(), inputView.getCarMove());
            OutputView.printExecutionResult(inputView.getCars(), inputView.getCarMove());
            System.out.println();
        }
    }

    public static void runMoveCar(String[] cars, int[] carMove) {
        for (int i = 0; i < cars.length; i++) {
            int randomInt = choiceRandomInt();
            if (randomMove(randomInt)) {
                carMove[i]++;
            }
        }
    }

    public static boolean randomMove(int randomInt) {
        if (randomInt >= 4) {
            return true;
        }
        return false;
    }

    public static int choiceRandomInt() {
        return Randoms.pickNumberInRange(0, 9);
    }
}

