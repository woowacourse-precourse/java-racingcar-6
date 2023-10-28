package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;

public class InputService {
    private final Cars cars = new Cars();
    private final CheckService checkService = new CheckService();
    private final static String SEPARATOR = ",";


    public void carNames() {
        String[] carArr = splitBySeparator(Console.readLine());
        if (checkService.cars(carArr)) {
            cars.create(carArr);
        }
    }

    public void numOfAttempts() {
        checkService.nums(Console.readLine());
    }

    public String[] splitBySeparator(String s) {
        return s.split(SEPARATOR);
    }
}
