package racingcar.view.output;

import java.util.List;
import racingcar.model.RacingCarPlayerModel;
import util.formatter.RacingCarFormatter;

public class RacingCarGameOutputView {
    private final RacingCarFormatter racingCarFormatter;
    public RacingCarGameOutputView(){
        this.racingCarFormatter = new RacingCarFormatter();
    }
    public void printWinners(List<RacingCarPlayerModel> winners){
        System.out.print("최종 우승자 : ");
        System.out.println(this.racingCarFormatter.formatListPlayersToString(winners));
        System.out.println();
    }
}
