package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameProgression {
    //TODO: 게임 진행 후 회당 결과 출력 및 점수 업데이트
    //TODO: findTopScore(), updateTopScore(), printResult()
    Player player = new Player();
    NumberOfGames numberOfGames = new NumberOfGames();
    private final int minNum = 0;
    private final int maxNum = 9;
    private final int isForward = 4;
    List<String> playerList = player.setThePlayer();
    List<Integer> scoreList = player.setScore(playerList);
    int repetition = numberOfGames.numOfGames();
    public void resultsPerGame(){
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
    private int ForB(int input){
        int fb = Randoms.pickNumberInRange(minNum,maxNum);
        System.out.println(fb); //test시 삭제할것
        if(fb>=isForward){
            return input+1;
        }
        else{
            return input;
        }
    }
}
