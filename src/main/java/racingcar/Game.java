package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    User user; //사용자 객체
    String[] carName; //자동차 명
    int[] score; //go 점수 반영
    List<Integer> max_index = new ArrayList<>(); //최댓값 보유 인덱스 저장을 위한 리스트

    int tryNum;//시도 횟수
    List<Integer> computer = new ArrayList<>();
    public Game(User user){
        this.user = user;
    }

    public void gameStart(){


        setDefaultValue();
        runGame();

        System.out.println();

        getWinner(carName,score);
    }

    private void setDefaultValue(){
        carName = user.getCarName();
        tryNum =user.getTryNum();
        score = new int[carName.length];
    }

    private void runGame() {
        System.out.println("실행결과");
        for(int i = 0; i < tryNum; i++){
            int[] goCount = setRandomCount(carName.length); //0~9까지 랜덤한 숫자 반영
            score = countScore(score,goCount);//랜덤한 숫자 추출하여 0,1 반영
            printresult(carName, score);
        }
    }


    private void getWinner(String[] carName, int[] score) {


        int max_score = getMaxScore();
        setMaxIndex(max_score);

        System.out.print("최종 우승자 : ");
        if(max_index.size() > 1){
            String result = Arrays.toString(carName);
            System.out.print(result.substring(1,result.length()-1));
        }
        else {
            System.out.println(carName[max_index.get(0)]);
        }
    }

    private void setMaxIndex(int max_score) {
        for(int i = 0; i <score.length; i++){
            System.out.println(score[i]);
            if (score[i] == max_score) max_index.add(i); // 최댓값에 해당하는 인덱스 저장
        }
    }

    private int getMaxScore(){
        int[] temp_score = score.clone();//최댓값 계산을 위한 임시 배열
        Arrays.sort(temp_score);//배열 정렬하여 최댓값 마지막 인덱스에
        return temp_score[temp_score.length-1]; // 최댓값 반환

    }

    public int[] setRandomCount(int carSize){ //Random한 moveValue(0~9) 부여
        int[] goCount = new int[carSize];
        for(int i=0; i<carSize; i++){
            goCount[i] = Randoms.pickNumberInRange(0,9);
        }
        return goCount;
    }

    public int[] countScore(int[]pre_score,int[] goCount){
        for(int i=0; i< goCount.length; i++){
            pre_score[i] += setScore(goCount[i]);
        }

        return pre_score;
    }
    public int setScore(int goCount){
        if (goCount >=4) return 1;
        else return 0;
    }

    public void printresult(String[] carName, int[] score){
        for(int i = 0; i < carName.length; i++){
            System.out.print(carName[i] + " : "); // 자동차 명 :
            for(int j = 0; j < score[i]; j++) {
                System.out.print("-"); // - 출력
            }
            System.out.println();//줄바꿈
        }
        System.out.println();
    }

}
