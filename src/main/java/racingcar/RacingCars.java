package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCars = new ArrayList<>();

    void add (RacingCar car) {
        racingCars.add(car);
    }

    public void turnOn() {
        for (RacingCar racingCar : racingCars) {
            int randomNumber = Randoms.pickNumberInRange(0,9);
            racingCar.drive(randomNumber);
        }
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }
}
