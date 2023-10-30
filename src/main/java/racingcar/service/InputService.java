package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.GameNum;
import racingcar.repository.CarsRepository;

public class InputService {
    private final CarsRepository carsRepository = new CarsRepository();
    private final CheckService checkService = new CheckService();
    private final static String SEPARATOR = ",";

    private final GameNum gameNum = new GameNum();

    public String input() {
        return Console.readLine();
    }

    public void carsName() {
        String[] carArr = splitBySeparator(input());
        if (checkService.cars(carArr)) {
            carsRepository.initCars(carArr);
        }
    }

    public void gameNum() {
        String input = input();
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