package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import racingcar.service.RacingService;
import racingcar.view.RacingView;

public class RacingController {
    public static void run() {
        RacingView.startGameMessage();
        HashMap<String, String> car = RacingService.enterCarName(Console.readLine());
        RacingView.enterRoundMessage();
    }
}
