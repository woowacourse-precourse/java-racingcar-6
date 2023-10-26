package racingcar.view;

import java.util.List;

public class Output {
    public void startGame(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void makeResult(String[] playerList){
        System.out.println("최종 우승자 : ");
        for(String player:playerList){
            System.out.print(player);
        }
    }
}
