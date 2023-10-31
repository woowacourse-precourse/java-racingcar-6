package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Race {
    private final static int MOVE_CONDITION_NUMBER = 4;
    private final static String MOVE = "-";
    private final static String NO_MOVE = "";
    List<Car> racingCar = new ArrayList<>();
    ;

    public Race(List<String> carNameList) {
        for (var carName : carNameList) {
            racingCar.add(new Car(carName));
        }
    }

    public void raincingCar() {
        racingCar.stream().forEach(car -> car.setPosition(movingCar()));
    }

    public List<Car> getRacingCar() {
        return racingCar;
    }

    private static String movingCar() {
        if(isMove(randomMoveNumber())) {
            return MOVE;
        }
        return NO_MOVE;
    }

    private static boolean isMove(int moveNumber) {
        return moveNumber >= MOVE_CONDITION_NUMBER ? true : false;
    }

    private static int randomMoveNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
