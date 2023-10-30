package racingcar;

import java.util.ArrayList;

public class Game {
    public void playerLapResult(String player, Integer numberOfMovements) {
        String movenmentBar = "";
        for (int i = 0; i < numberOfMovements; i++) {
            movenmentBar += "-";
        }

        System.out.print(player + " : " + movenmentBar);
    }

    public void printTotalLapResult(ArrayList<Integer> gameResult, ArrayList<String> carList) {
        for (int i = 0; i < carList.size(); i++) {
            String currentPlayer = carList.get(i);
            Integer currentPlayerResult = gameResult.get(i);
            playerLapResult(currentPlayer, currentPlayerResult);
        }
    }

    public void startRace(ArrayList<String> carList, ArrayList<Integer> gameResult) {
        gameResult = Judgement.playerMoveForward(gameResult); // 새로운 결과로 덮어쓰기
    }

}
