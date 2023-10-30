package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.repository.GameRepository;

public class InputService {
    private final GameRepository gameRepository = new GameRepository();
    private final CheckService checkService = new CheckService();
    private final static String SEPARATOR = ",";

    public String input() {
        return Console.readLine();
    }

    public void carsName() {
        String[] carArr = splitBySeparator(input());
        if (checkService.cars(carArr)) {
            gameRepository.initCars(carArr);
        }
    }

    public void gameNum() {
        String input = input();
        if (checkService.nums(input)) {
            gameRepository.initGameNum(StringToInt(input));
        }
    }

    public String[] splitBySeparator(String s) {
        return s.split(SEPARATOR);
    }

    public int StringToInt(String s) {
        return Integer.parseInt(s);
    }

    public int getGameNum() {
        return gameRepository.getGameNum();
    }

    public Cars getCars() {
        return gameRepository.getCars();
    }
}