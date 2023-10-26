package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
public class Game {
    Player player = new Player();
    List<String> palyerList =  player.setThePlayer();;
    List<Integer> scoreList = player.setScore(palyerList);
    List<String> topScorers = new ArrayList<>();
    int repetition = player.numOfGames(); //반복횟수
    public void playGame(){
        //calculateScore();
        showResult();
        findTopScore(palyerList, scoreList);
        System.out.println("최종 우승자 : " + String.join(", ", topScorers));
    }

    private void calculateScore(){
        for(int i=0; i< scoreList.size(); i++){
            int score = ForB(scoreList.get(i));
            scoreList.set(i,score);
        }
    }

    private void findTopScore( List<String> palyerList,List<Integer> scoreList ){
        int maxScore  = Integer.MIN_VALUE;
        for (int i = 0; i < scoreList.size(); i++) {
            int currentScore = scoreList.get(i);
            if (currentScore > maxScore ) {
                maxScore  = currentScore;
                topScorers.clear();
                topScorers.add(palyerList.get(i));
            } else if (currentScore == maxScore) {
                topScorers.add(palyerList.get(i));
            }
        }
    }
    private void showResult(){
        for(int i=0; i<repetition; i++){
            calculateScore();
            resultOfGame();
        }
    }

    private void resultOfGame(){
        System.out.println("실행 결과");
        for(int i=0; i<palyerList.size(); i++){
            System.out.println(palyerList.get(i) +" : " + "- ".repeat(scoreList.get(i)));
        }
    }
    private int ForB(int input){
        int fb = Randoms.pickNumberInRange(0,9);
        //System.out.println(fb);
        if(fb>=4){
            return forward(input);
        }
        else{
            return backward(input);
        }
    }

    private int forward(int input){
        return input+1;
    }
    private int backward(int input){
        return input;
    }
}

