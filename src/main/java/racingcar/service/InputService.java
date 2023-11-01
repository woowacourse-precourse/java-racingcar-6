package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.GameNum;

public class InputService {
    private final InputValidator inputValidator = new InputValidator();
    private final static String SEPARATOR = ",";
    private final Cars cars = Cars.create();
    private final GameNum gameNum = new GameNum();

    public String input() {
        return Console.readLine();
    }

    public void carsName(String input) {
        String[] carArr = splitBySeparator(input);
        if (inputValidator.cars(carArr)) {
            cars.init(carArr);
        }
    }

    public void gameNum(String input) {
        if (inputValidator.nums(input)) {
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