package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarNameSeperator;

public class RacingCarService {

    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;
    private static final int STANDARD_OF_JUDGMENT = 4;

    private final CarNameSeperator carNameSeperator;

    private List<Car> cars;

    public RacingCarService() {
        this.carNameSeperator = new CarNameSeperator();
    }

    public void saveCarName(final String input) {
        List<String> seperatedCarNames = carNameSeperator.seperateCarNames(input);
        seperatedCarNames.stream()
                .map(Car::new)
                .forEach(cars::add);
    }

    public void moveCar(final String input) {
        int repeatCount = Integer.parseInt(input);
        for (int i = 0; i < repeatCount; i++) {
            judgeMoveCar();
        }
    }

    private void judgeMoveCar() {
        int pick = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
        for (Car car : cars) {
            carDistanceIncrease(pick, car);
        }

    }

    private void carDistanceIncrease(final int pick, final Car car) {
        if (pick < STANDARD_OF_JUDGMENT) {
            car.increaseDistance();
        }
    }


}
