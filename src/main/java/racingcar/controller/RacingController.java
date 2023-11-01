package racingcar.controller;

import java.util.List;
import racingcar.model.Players;
import racingcar.model.RacingReferee;
import racingcar.model.RandomDice;
import racingcar.view.View;

public class RacingController {

    private final View view;
    private RacingReferee racingReferee;

    public RacingController(View view) {
        this.view = view;
    }

    public void run() {

        Players players = new Players(getStringListFromString(view.printInputCarsNames()));
        int racingTime = view.printInputRacingTime();

        racingReferee = new RacingReferee(players, new RandomDice());

        view.printResultMessage();
        conductRace(racingTime);
        view.printWinnerNames(racingReferee.getWinner());
    }

    private void conductRace(int racingTime) {
        for (int i = 0; i < racingTime; i++) {
            view.printMovedLog(racingReferee.playerMove());
        }
    }

    private List<String> getStringListFromString(String string) {
        return List.of(string.split(","));
    }

}
