package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import model.Player;


import java.util.ArrayList;
import java.util.List;

import static controller.InputValidator.numberHandlingException;

public class CarRaceGame {

    public static void run(String number, Player[] players) {
        int gameCount = numberHandlingException(number);
        System.out.println("실행 결과");
        for(int i = 0; i < gameCount; i++){
            generateRandomNumber(players);
            printResult(players);
            System.out.println();
        }
        System.out.print("최종 우승자 : ");
        List<String> winners = getWinner(players);
        for(int i = 0; i < winners.size(); i++){
            if(i == winners.size()-1)
                System.out.print(winners.get(i));
            else
                System.out.print(winners.get(i) + ", ");
        }
    }

    public static void generateRandomNumber(Player[] players) {
        for(int i = 0; i < players.length; i++) {
            players[i].setRandomNumber(Randoms.pickNumberInRange(0,9));
        }
    }
    public static void printResult(Player[] players) {
        for(int i = 0; i < players.length; i++){
            System.out.println(players[i].getName() + " : " + players[i].ReturnDistanceLine());
        }
    }
    public static int getMaxDistance(Player[] players){
        int maxDistance = 0;
        for(Player player : players) {
            if (maxDistance < player.getDistance())
                maxDistance = player.getDistance();
        }
        return maxDistance;
    }
    public static List<String> getWinner(Player[] players){
        List<String> winners = new ArrayList<>();
        int maxDistance = getMaxDistance(players);
        for(Player player : players){
            if(player.getDistance() == maxDistance)
                winners.add(player.getName());
        }
        return winners;
    }

}
