package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.view.OutputView;

public class CarRacing {

    List<String> cars;
    List<Integer> carPos;

    public CarRacing(List<String> cars) {
        this.cars = cars;
        this.carPos = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            carPos.add(0);
        }
    }

    public void race(int turn) {
        while (turn-- > 0) {
            oneTurnRace();
        }
    }

    private void oneTurnRace() {
        for (int i = 0; i < cars.size(); i++) {
            int r = Randoms.pickNumberInRange(0, 9);
            if (r >= 4) {
                carPos.set(i, carPos.get(i) + 1);
            }
        }
    }
}
