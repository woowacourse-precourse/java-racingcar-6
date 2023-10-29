package racingcar.race;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Race {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MIX_RANDOM_NUMBER = 9;
    private static final int GO_FORWARD = 4;

    private List<Car> cars = new ArrayList<>();

    public void saveName(List<String> carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        for (Car car : cars) {
            System.out.println(car.getName());
        }
    }
    public boolean decideGo() {
        boolean go = false;
        int randomNum = pickNumberInRange(MIN_RANDOM_NUMBER, MIX_RANDOM_NUMBER);
        if (randomNum >= GO_FORWARD) {
            go = true;
        }
        return go;
    }
    public void goFoward() {
        for (Car car : cars) {
            if (decideGo()) {
                car.plusPosition();
            }
        }
        for (Car car : cars) {
            System.out.println(car.addDash());
        }
    }
}
