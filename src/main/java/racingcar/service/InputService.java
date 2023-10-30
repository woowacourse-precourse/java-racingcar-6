package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.repository.GameRepository;

public class InputService {
    private final GameRepository gameRepository = new GameRepository();
    private final CheckService checkService = new CheckService();
    private final static String SEPARATOR = ",";

    public String init() {
        return Console.readLine();
    }

    public void carNames(String input) {
        String[] carArr = splitBySeparator(input);
        if (checkService.cars(carArr)) {
            gameRepository.addCars(carArr);
        }
    }

    public void numOfAttempts(String input) {
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

    public int findGameNum() {
        return gameRepository.findGameNum();
    }
}