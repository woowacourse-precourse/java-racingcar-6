package racingcar.view;

import static racingcar.Constants.INPUT_CAR_NAMES;
import static racingcar.Constants.INPUT_TRY_NUMBER;

import java.util.List;
import racingcar.model.RacingCarPlayerModel;
import util.formatter.RacingCarFormatter;

public class RacingCarGameView {
    private final RacingCarFormatter racingCarFormatter;

    public RacingCarGameView(){
        this.racingCarFormatter = new RacingCarFormatter();
    }

    public void printInputRacingCarPlayers(){
        System.out.println(INPUT_CAR_NAMES);
    }

    public void printInputTryCount(){
        System.out.println(INPUT_TRY_NUMBER);
    }

    public void printWinners(List<RacingCarPlayerModel> winners){
        System.out.print("최종 우승자 : ");
        System.out.println(this.racingCarFormatter.formatListRacingCarPlayersToString(winners));
        System.out.println();
    }
}
