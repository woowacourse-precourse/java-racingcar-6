package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import utils.RandomUtils;

public class Cars {

    private static final int RANDOM_START_VALUE = 0;
    private static final int RANDOM_END_VALUE = 10;
    private static final int GO_FORWARD_VALUE = 4;
    private static final String MOVE_SIGN = "-";

    private List<Car> cars;

    public Cars(List<String> names) {
        cars = names.stream().map(Car::new).collect(Collectors.toList());
    }

    private boolean isGoForward() {
        return RandomUtils.nextInt(RANDOM_START_VALUE, RANDOM_END_VALUE) >= GO_FORWARD_VALUE;
    }
    public static void main(String[] args) {
    }

    public void showRaceStateResultMessage() {
    }

    public void doRace(int tryTimes) {
    }

    public void showRaceResult() {
    }
}
