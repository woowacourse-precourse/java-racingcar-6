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
        return this.carName;
    }

    public List<String> getDistance() {
        return this.distance;
    }

    public String getNameAndDistance() {
        return this.carName + " : " + this.distance
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void move() {
        if (pickRandomNumber() > 3) {
            this.distance.add("-");
        }
        System.out.println(getNameAndDistance());
    }
}
