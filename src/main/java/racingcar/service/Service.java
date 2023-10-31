package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

public class Service {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private final OutputView outputView = new OutputView();

    public void goOrStop(int[] carPresentPoint) {
        for (int i = 0; i < carPresentPoint.length; i++) {
            if (Randoms.pickNumberInRange(0, 9) >= MOVING_FORWARD) carPresentPoint[i] += 1;
        }
    }

    public void resultOfExecution(int count, int[] carPresentPoint, String[] carName) {
        for (int i = 0; i < count; i++) {
            goOrStop(carPresentPoint);
            outputView.outputOfExecution(carPresentPoint, carName);
        }
    }

    public String getWinner(String[] carName, int[] carPresentPoint) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < carPresentPoint.length; i++) {
            max = Math.max(max, carPresentPoint[i]);
        }

        String answer = "";
        for (int i = 0; i < carName.length; i++) {
            if (carPresentPoint[i] == max) {
                answer += carName[i];
                answer += ", ";
            }
        }
        answer = answer.substring(0, answer.length() - 2);

        return answer;
    }
}
