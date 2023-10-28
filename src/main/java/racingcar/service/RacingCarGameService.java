package racingcar.service;

import static racingcar.input.RacingCarInputReader.getRacingCarMapFromConsole;

import java.util.Map;

public class RacingCarGameService {

    public static void startGame() {
        Map<String, RacingCar> racingCarMap = getRacingCarMapFromConsole();
    }
}
