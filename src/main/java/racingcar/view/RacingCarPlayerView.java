package racingcar.view;

import static racingcar.Constants.MOVE;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.RacingCarPlayerModel;

public class RacingCarPlayerView {
    public void printPlayerPosition(RacingCarPlayerModel racingCarPlayer){
        System.out.print(racingCarPlayer.getCarName() + " : ");
        IntStream.range(0, racingCarPlayer.getCurrentPosition())
            .forEach(i -> System.out.print(MOVE));
        System.out.println();
    }

    public void printPlayersPosition(List<RacingCarPlayerModel> racingCarPlayers){
        racingCarPlayers.forEach(this::printPlayerPosition);
        System.out.println();
    }
}
