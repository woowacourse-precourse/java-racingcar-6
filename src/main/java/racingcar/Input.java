package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;

public class Input {
    private int round;
    private ArrayList<String> player;

    public void inputPlayer(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String stringPlayer=Console.readLine();
        setPlayerName(stringPlayer);
    }
    public void setPlayerName(String stringPlayer){
        player= new ArrayList<>(Arrays.asList(stringPlayer.split(",")));
        for (String playerName:
             player) {
            validateName(playerName);
        }
    }
    public ArrayList<String> getPlayerName(){
        return player;
    }
    public void validateName(String playerName){
        if (!(playerName.length()<=5))
            throw new IllegalArgumentException("플레이어의 이름은 5자 이하만 가능합니다.");

    }
    public void inputRound(){
        System.out.println("시도할 회수는 몇회인가요?");
        int intRound=Integer.parseInt(Console.readLine());
        setRound(intRound);
    }
    public void setRound(int intRound){
        round= intRound;
    }
    public int getRound(){
        return round;
    }

}
