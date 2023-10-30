package racingcar;

import java.util.ArrayList;

public class Game {
    public static void playerLapResult(String player, Integer numberOfMovements) {
        String movenmentBar = "";
        for (int i = 0; i < numberOfMovements; i++) {
            movenmentBar += "-";
        }

        System.out.print(player + " : " + movenmentBar +"\n");
    }

    public static void printTotalLapResult(ArrayList<Integer> gameResult, ArrayList<String> carList) {
        for (int i = 0; i < carList.size(); i++) {
            String currentPlayer = carList.get(i);
            Integer currentPlayerResult = gameResult.get(i);
            playerLapResult(currentPlayer, currentPlayerResult);
        }
    }

    public static ArrayList<Integer> startRace(ArrayList<String> carList, ArrayList<Integer> gameResult) {
        ArrayList<Integer> currentGameResult = Judgement.playerMoveForward(gameResult); // 새로운 결과
        printTotalLapResult(currentGameResult, carList);
        System.out.println("\n");

        return currentGameResult;
    }

}
