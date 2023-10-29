package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public String getNameAndDistance() {
        return this.carName + " : " + distance
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) > 3) {
            distance.add("-");
        }
        System.out.println(getNameAndDistance());
    }
}
