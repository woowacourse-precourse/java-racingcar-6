package racingcar.view;

import java.util.List;
import racingcar.model.RacingCarPlayerModel;

public class RacingCarPlayerView {
    private static final String MOVE = "-";
    public void printPlayerPosition(RacingCarPlayerModel racingCarPlayer){
        System.out.print(racingCarPlayer.getCarName() + " : ");
        for(int i = 0; i < racingCarPlayer.getCurrentPosition(); i++){
            System.out.print(MOVE);
        }
        System.out.println();
    }

    public void printPlayersPosition(List<RacingCarPlayerModel> racingCarPlayers){
        racingCarPlayers.forEach(this::printPlayerPosition);
        System.out.println();
    }
}
