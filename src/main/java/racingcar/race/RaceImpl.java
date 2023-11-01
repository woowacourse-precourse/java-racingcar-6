package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.car.CarImpl;

public class RaceImpl implements Race{
    private List<CarImpl> cars = new ArrayList<>();

    public RaceImpl(String[] carNames) {
        for (String name : carNames) {
            cars.add(new CarImpl(name));
        }
    }

    public void start(int rounds) {
        for (int i = 0; i < rounds; i++) {
            round();
            System.out.println();
        }
    }

    public List<CarImpl> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void round() {
        for (CarImpl car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
            System.out.println(car);
        }
    }

}
