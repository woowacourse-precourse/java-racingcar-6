package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.GameNum;

public class InputService {
    private final Cars cars = new Cars();
    private final GameNum gameNum = new GameNum();
    private final CheckService checkService = new CheckService();
    private final static String SEPARATOR = ",";

    public String init() {
        return Console.readLine();
    }

    public void carNames(String input) {
        String[] carArr = splitBySeparator(input);
        if (checkService.cars(carArr)) {
            cars.create(carArr);
        }
    }

    public void numOfAttempts(String input) {
        if (checkService.nums(input)) {
            gameNum.init(StringToInt(input));
        }
    }

    public String[] splitBySeparator(String s) {
        return s.split(SEPARATOR);
    }

    public int StringToInt(String s) {
        return Integer.parseInt(s);
    }
}
