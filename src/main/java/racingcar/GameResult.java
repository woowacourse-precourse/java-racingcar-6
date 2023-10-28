package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    //TODO: scoreList를 받아와서 최고득점자 리스트 반환 , 문자열 출력
    //TODO: findTopScore(), updateTopScore(), printResult()
    GameProgression gameProgression;

    List<String> topScorerList = new ArrayList<>();
    int topScore = Integer.MIN_VALUE;

    public GameResult(GameProgression gameProgression) {
        this.gameProgression = gameProgression;
    }

    public void GameEndResults() {
        List<Integer> scoreList = gameProgression.scoreList;
        List<String> playerList = gameProgression.playerList;
        findTopScore(scoreList, playerList);
    }

    private void findTopScore(List<Integer> scoreList, List<String> playerList) {
        for (int i = 0; i < scoreList.size(); i++) {
            int currentScore = scoreList.get(i);
            updateTopScore(currentScore, playerList.get(i));
        }
        printResult();
    }

    private void updateTopScore(int currentScore, String player) {
        if (currentScore > topScore) {
            topScore = currentScore;
            topScorerList.clear();
            topScorerList.add(player);
        } else if (currentScore == topScore) {
            topScorerList.add(player);
        }
    }

    private void printResult() {
        System.out.println("최종 우승자 : " + String.join(", ", topScorerList));
    }

}
