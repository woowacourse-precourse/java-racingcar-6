package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGameService {

    private List<Car> carList = new ArrayList<>();

    public void init(String[] carNamesArr) {
        this.carList = mapToCarList(carNamesArr);
    }

    private List<Car> mapToCarList(String[] carNamesArr) {
        return Arrays.stream(carNamesArr).map(n -> new Car(n)).toList();
    }

    public void playGame(int count) {
        OutputView.printResult();
        for (int i = 0; i < count; i++) {
            play(carList);
            OutputView.printNewLine();
        }

    }

    private void play(List<Car> carList) {
        for (Car car : carList) {
            if (canMoveForward()) {
                car.moveForward();
            }
            OutputView.printCarPosition(car);
        }
    }

    private boolean canMoveForward() {
        return 4 <= Randoms.pickNumberInRange(0, 9);
    }
}
