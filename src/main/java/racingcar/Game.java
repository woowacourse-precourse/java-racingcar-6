package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {

    private static final int RANDOM_NUMBER = 4;
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;
    private final InputView inputView;
    private final OutputView outputView;

    public Game() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        List<Car> cars = inputView.inputCarName();
        int roundCnt = inputView.inputRoundCnt();
        while (roundCnt-- > 0) {
            judgeMoving(cars);
            outputView.printRound(cars);
        }
        System.out.println("최종 우승자 : " + outputView.getWinner(cars));
    }

    public void judgeMoving(List<Car> cars) {
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (randomNum >= RANDOM_NUMBER) {
                car.moveForward();
            }
        }
    }
}
