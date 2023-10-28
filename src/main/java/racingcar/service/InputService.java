package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Cars;

public class InputService {
    private final Cars cars = new Cars();

    public void carNames() {
        String[] split = Console.readLine().split(",");
        cars.create(split);
    }

    public void tryNum() {
        String num = Console.readLine();
    }
}
