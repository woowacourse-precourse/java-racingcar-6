package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.GameNum;

public class InputService {
    private final Cars cars = new Cars();
    private final CheckService checkService = new CheckService();
    private final static String SEPARATOR = ",";
    private GameNum gameNum = new GameNum();

    public void carNames() {
        String[] carArr = splitBySeparator(Console.readLine());
        if (checkService.cars(carArr)) {
            cars.create(carArr);
        }
    }

    public void numOfAttempts() {
        String s = Console.readLine();
        if (checkService.nums(s)) {
            gameNum.create(StringToInt(s));
        }
    }

    public String[] splitBySeparator(String s) {
        return s.split(SEPARATOR);
    }

    public int StringToInt(String s) {
        return Integer.parseInt(s);
    }
}
