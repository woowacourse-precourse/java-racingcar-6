package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Set;

public class Car {
    private final HashMap<String, Integer> racingLineup;

    Car(String[] names) {
        this.racingLineup = new HashMap<>();
        for (String name : names) {
            this.racingLineup.put(name, 0);
        }
    }

    void moveCar(Car cars) {
        Set<String> carNames = this.racingLineup.keySet();
        for (String name : carNames) {
            increaseCarPosition(name);
        }
    }

    boolean checkCarMove() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        return randomNumber > 3;
    }

    void increaseCarPosition(String name) {
        if (checkCarMove()) {
            this.racingLineup.put(name, this.racingLineup.get(name) + 1);
        }
    }

}
