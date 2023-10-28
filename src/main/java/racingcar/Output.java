package racingcar;

import java.util.ArrayList;

public class Output {
    private ArrayList<String> goalPlayer;
    public void printRound(ArrayList<String> player,ArrayList<Integer> playerResult){
        for (int i = 0; i < player.size(); i++) {
            System.out.println(player.get(i)+" : "+"-".repeat(playerResult.get(i)));
        }
    }
    public void goal(ArrayList<String> goalPlayer) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < goalPlayer.size(); i++) {
            System.out.print(goalPlayer.get(i)+", ");
        }
    }
}
