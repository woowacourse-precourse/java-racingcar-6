package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Cars;

public class InputService {
    private final Cars cars = new Cars();
    private final CheckService checkService = new CheckService();

    public void carNames() {
        String[] split = Console.readLine().split(",");
        checkService.cars(split);
        cars.create(split);
    }

    public void numOfAttempts() {
        String num = Console.readLine();
        checkService.nums(num);
    }
}
