package racingcar.view;

import racingcar.domain.Player;

import java.util.ArrayList;

public class GameView {

    public void gameRunView(){
        System.out.println("\n실행 결과");
    }

    public void runView(ArrayList<Player> players){
        for (Player player : players) {
            System.out.print(player.getName() + " : ");
            lineView(player.getRunCount());
            System.out.println();
        }
        System.out.println();
    }

    public void lineView(int runCount){
        for(int i=0; i<runCount; i++){
            System.out.print("-");
        }
    }
}
