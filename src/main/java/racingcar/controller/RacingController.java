package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RacingService;

import java.util.List;

public class RacingController {

    private RacingService racingService = new RacingService();
    public List<String> getUserInput() {
        String input = Console.readLine();
        return racingService.stringToList(input);
    }
}
