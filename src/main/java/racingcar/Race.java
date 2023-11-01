package racingcar;

import java.util.List;

import racingcar.dto.Car;
import racingcar.global.Validator;
import racingcar.global.util.RandomUtil;

public class Race {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int MIN_FORWARD_NUMBER = 4;
    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final String CAR_NAME_DELIMITER = ",";

    private List<Car> cars;
    private int count;

    public void init() {
        RaceIO.announceGetCarName();
        List<String> carName = Validator.carName(RaceIO.getCarNameAsList());
        this.cars = RaceHelper.setCars(carName);

        RaceIO.announceGetCount();
        count = Validator.count(RaceIO.getCount());
    }

    public void start() {
        for (int i = 0; i < count; ++i) {
            this.randomMove();
        }
    }

    private void randomMove() {
        cars.forEach(car -> {
            boolean moveForward = RandomUtil.trueOrFalse(MIN_NUMBER, MAX_NUMBER, MIN_FORWARD_NUMBER);
            if (moveForward) {
                car.moveForward();
            }
        });
    }
}
