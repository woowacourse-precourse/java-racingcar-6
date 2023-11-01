package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.User;
import racingcar.service.RacingGameService;

import java.util.List;

public class RacingGameController {
    private final RacingGameService racingGameService = new RacingGameService();

    public void start(){
        User user = new User();
        RacingGame racingGame = new RacingGame();
        racingGameService.initGame(user, racingGame);



    }
}
