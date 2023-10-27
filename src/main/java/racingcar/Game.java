package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
public class Game {
    //TODO : 게임 진행 클래스 , 결과 도출 클래스 분리
    Player player = new Player();
    List<String> playerList =  player.setThePlayer();;
    List<Integer> scoreList = player.setScore(playerList);
    List<String> topScorerList = new ArrayList<>();
    int topScore  = Integer.MIN_VALUE;
    int repetition = player.numOfGames(); //반복횟수
    public void playGame(){
        showResult();
        findTopScore();
        System.out.println("최종 우승자 : " + String.join(", ", topScorerList));
    }
    private void showResult(){
        for(int i=0; i<repetition; i++){
            calculateScore();
            resultOfGame();
        }
    }
    private void calculateScore(){
        for(int i=0; i< scoreList.size(); i++){
            int score = ForB(scoreList.get(i));
            scoreList.set(i,score);
        }
    }
    private void resultOfGame(){
        System.out.println("실행 결과");
        for(int i = 0; i< playerList.size(); i++){
            System.out.println(playerList.get(i) +" : " + "- ".repeat(scoreList.get(i)));
        }
    }
    private void findTopScore(){

        for (int i = 0; i < scoreList.size(); i++) {
            int currentScore = scoreList.get(i);
            updateTopScore(currentScore,i);
        }
    }
    private void updateTopScore(int currentScore, int i){ //최고득점자 판별 메서드
        if (currentScore > topScore ) {
            topScore  = currentScore;
            topScorerList.clear();
            topScorerList.add(playerList.get(i));
        } else if (currentScore == topScore) {
            topScorerList.add(playerList.get(i));
        }
    }
    private int ForB(int input){
        int fb = Randoms.pickNumberInRange(0,9);
        System.out.println(fb); //test시 삭제할것
        if(fb>=4){
            return input+1;
        }
        else{
            return input;
        }
    }
}

