package racingcar.model;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.controller.CarNameJudgment;

public class CarService {
    public final int MOVE_LIMIT_CONDITION = 4;
    public final int CAR_NAME_LIMIT_SIZE = 5;
    public int carOnceMove = 0;
    public int epoch = 0;

    public void inputCarName() {
        String carName = readLine();
        CarObject.name = CarNameJudgment.splitOf(carName);
    }

    public void inputEpoch() {
        int epoch = Integer.parseInt(readLine());
    }

    public void setCarOnceMoveDistance() {
        do {
            carOnceMove = Randoms.pickNumberInRange(0, 9);
        } while (carOnceMove <= MOVE_LIMIT_CONDITION);
    }

    private void CarNameJudgment(String carName) {
        CarObject.name = (ArrayList<String>) Arrays.asList(carName.split(","));

        for (var car : CarObject.name) {
            if (carNameSizeJudgment(car) == null) {
                new IllegalArgumentException();
                break;
            }
            judgmentCarName.add(carNameSizeJudgment(car));
        }
    }

}
