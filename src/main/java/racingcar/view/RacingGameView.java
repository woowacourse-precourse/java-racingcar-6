package racingcar.view;

import java.util.ArrayList;
import java.util.Vector;
import racingcar.domain.Player;

public class RacingGameView {
    public void printInputPlayersMsg(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputGameTurnMsg(){
        System.out.println("시도할 회수는 몇회인가요?");
    }


    public void printInitResultMsg(){
        System.out.println();
        System.out.println("실행 결과");
    }
    public void printTurnResultMsg(Vector<Player> players){
        for (Player player: players){
            System.out.print(player.getName()+" : ");
            //score 출력
            for (int i = 0; i<player.getScore();i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void printResultMsg(ArrayList<Player> winners){
        System.out.print("최종 우승자 : ");
        System.out.print(winners.remove(0).getName());
        while(!winners.isEmpty()){
            System.out.print(", " + winners.remove(0).getName());
        }

    }
}
