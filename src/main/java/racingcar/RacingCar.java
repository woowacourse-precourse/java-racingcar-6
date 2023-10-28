package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public final class RacingCar {
    private final String carName;
    private final List<String> distance = new ArrayList<>();

    public RacingCar(final String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public List<String> getDistance() {
        return distance;
    }

    public void getNameAndDistance() {
        System.out.print(this.carName + " : ");
        distance.forEach(System.out::print);
        System.out.println();
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) > 3) {
            distance.add("-");
        }
    }
}
