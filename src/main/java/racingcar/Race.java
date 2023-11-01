package racingcar;

import java.util.List;

import racingcar.dto.Car;

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
        List<String> carName = RaceIO.getCarNameAsList();
        this.cars = RaceHelper.setCars(carName);

        RaceIO.announceGetCount();
        count = Integer.parseInt(RaceIO.getCount());
    }
}
