package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.CarList;
import racingcar.View.OutputView;

public class MoveORStop {
    private static final String RandomNumberRange = "무작위 값이 범위를 벗어났습니다.";
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;


    public static void RacingCar(CarList car) {
        int moving = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
        car.moving(moving);
        OutputView.moveForward(car, moving);
    }

    public static void validateRandomNumberRange(int randomNumber) {
        if (randomNumber > END_NUMBER || randomNumber < START_NUMBER) {
            throw new IllegalArgumentException(RandomNumberRange);
        }
    }
}
