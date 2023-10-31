package racingcar;

import java.util.ArrayList;

public class Output {
    private ArrayList<String> goalPlayer;

    public void printRound(ArrayList<String> player, ArrayList<Integer> playerResult) {
        for (int i = 0; i < player.size(); i++) {
            System.out.println(player.get(i) + " : " + "-".repeat(playerResult.get(i)));
        }
    }

    public void goal(ArrayList<String> goalPlayer, ArrayList<Integer> goalNumber) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < goalNumber.size(); i++) {
            int goal = goalNumber.get(i);
            if (i != goalNumber.size() - 1) {
                System.out.print(goalPlayer.get(goal) + ", ");
            } else if (i == goalNumber.size() - 1) {
                System.out.print(goalPlayer.get(goal));
            }

        }
    }
}
