package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Judge {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;
    private static final int MOVE_AVAILABLE_NUM = 4;

    public boolean isMoveAvailable() {
        int pickedNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
        return pickedNumber >= MOVE_AVAILABLE_NUM;
    }


    public List<String> getFinalWinner(List<Car> cars) {
        List<String> finalWinners = new ArrayList<>();
        Collections.sort(cars);
        int max = Collections.max(cars).getScore();
        for (Car car : cars) {
            if (car.getScore() == max) {
                finalWinners.add(car.getName());
            }
        }
        return finalWinners;
    }
}
