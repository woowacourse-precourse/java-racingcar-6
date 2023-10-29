package racingcar.domain;

import static racingcar.constant.CarConstant.MAX_MOVE_CONDITION_NUMBER;
import static racingcar.constant.CarConstant.MIN_MOVE_CONDITION_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarNames;
import racingcar.view.OutputView;

/*
 *   플레이어의 정보를 담당
 * */

public class GamePlayer {
    private final List<Car> cars = new ArrayList<>();

    private GamePlayer(CarNames carNames) {
        for (String carName : carNames.getCarNames()) {
            cars.add(new Car(carName));
        }
    }

    public static GamePlayer from(CarNames carNames) {
        return new GamePlayer(carNames);
    }

    public GameRank createGameRank() {
        return new GameRank(cars);
    }

    public void moveCars() {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    private void moveCar(Car car) {
        int number = Randoms.pickNumberInRange(MIN_MOVE_CONDITION_NUMBER, MAX_MOVE_CONDITION_NUMBER);
        car.moveOrStop(number);
        OutputView.moveResult(car.recordToMoveSign());
    }

}
