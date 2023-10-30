package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingPlayer;
import racingcar.service.RacingService;
import racingcar.view.InputView;

public class GameController {

    private final InputView inputView = new InputView();
    private final RacingService racingService = new RacingService();

    public void runGame(){
        String cars = inputView.inputCarNames();
        List<String> racerList = racingService.racerNameStringToList(cars);

        racingService.validateNames(racerList);

        List<RacingPlayer> playersList = racingService.storeCarNames(racerList);

        String countInput = inputView.inputAttemptCount();

        racingService.validateCount(countInput);

        int count = racingService.countStringToInt(countInput);

        conductRace(playersList, count);
    }

    public void conductRace(List<RacingPlayer> playersList, int count){

    }
}
