package racingcar.view;

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

    // 각 회수 실행 결과 출력

    // 단독 우승자 안내문구

    // 공동 우승자 안내문구
}
