package racingcar.view;

import java.util.List;
import racingcar.model.RacingCarPlayerModel;
import util.formatter.RacingCarFormatter;

public class RacingCarGameView {
    private final RacingCarFormatter racingCarFormatter;

    public RacingCarGameView(){
        this.racingCarFormatter = new RacingCarFormatter();
    }

    public void printInputRacingCarPlayers(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printWinners(List<RacingCarPlayerModel> winners){
        System.out.print("최종 우승자 : ");
        System.out.println(this.racingCarFormatter.formatListRacingCarPlayersToString(winners));
        System.out.println();
    }
}
