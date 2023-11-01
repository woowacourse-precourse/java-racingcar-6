package racingcar;

import java.util.ArrayList;

public class Game {
    public static void playerLapResult(String player, Integer numberOfMovements) {
        String movenmentBar = "";
        for (int i = 0; i<numberOfMovements; i++) {
            movenmentBar += "-";
        }
        System.out.print(player + " : " + movenmentBar +"\n");
    }

    public static void printTotalLapResult(ArrayList<Integer> gameResult, ArrayList<String> playerList) {
        String currentPlayer;
        Integer currentPlayerResult;
        for (int i = 0; i < playerList.size(); i++) {
            currentPlayer = playerList.get(i);
            currentPlayerResult = gameResult.get(i);
            playerLapResult(currentPlayer, currentPlayerResult);
        }
    }

    public static ArrayList<Integer> startRace(ArrayList<String> playerList, ArrayList<Integer> gameResult) {
        ArrayList<Integer> currentGameResult = Judgement.playerMoveForward(gameResult); // 새로운 결과
        printTotalLapResult(currentGameResult, playerList);
        System.out.println("\n");

        return currentGameResult;
    }

}
