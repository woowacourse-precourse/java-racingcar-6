package racingcar.service;

import static racingcar.input.RacingCarInputReader.getRacingCarMapFromConsole;

import java.util.Map;
import racingcar.input.RacingCarInputReader;

public class RacingCarGameService {

    public static void startGame() {
        Map<String, RacingCar> racingCarMap = getRacingCarMapFromConsole();
        int numberToPlay = RacingCarInputReader.getPlayNumberFromConsole();
    }
}
