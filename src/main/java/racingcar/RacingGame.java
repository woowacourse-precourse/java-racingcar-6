package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;

public class RacingGame {
    static HashMap<String,Integer> scoreboard;

    public static HashMap<String, Integer> getScoreboard() {
        return scoreboard;
    }

    public static void setScoreboard(HashMap<String, Integer> scoreboard) {
        RacingGame.scoreboard = scoreboard;
    }

    public RacingGame() {
        scoreboard = new HashMap<String,Integer>();
    }
    static void checkName(String name){
        if(name.length() > 5 || name.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    static void countForward(){
        for(String key:scoreboard.keySet()){
            int randomNumber = Randoms.pickNumberInRange(0,9);
            if(randomNumber >= 4){
                scoreboard.put(key,scoreboard.get(key)+1);
            }
        }
    }

    static void raceProgress(int tryCount){
        for(int i=0;i<tryCount;i++){
            countForward();
            showScore();
        }
    }

    public static String scoretoString(int score){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<score;i++){
            stringBuffer.append("-");
        }
        return stringBuffer.toString();
    }

    public static void showScore() {
        for(String key:scoreboard.keySet()){
            System.out.println(key + " : " + scoretoString(scoreboard.get(key)));
        }
        System.out.println();
    }

    public String chooseWinner() {
        StringBuffer stringBuffer = new StringBuffer();
        int maxScore = 0;
        for(String key:scoreboard.keySet()){
            int keyScore = scoreboard.get(key);
            if(maxScore<=keyScore){
                maxScore = keyScore;
            }
        }
        for(String key:scoreboard.keySet()){
            if(scoreboard.get(key) == maxScore){
                stringBuffer.append(key + ", ");
            }
        }
        stringBuffer.setLength(stringBuffer.length()-2); // 마지막부분 쉼표 자르기
        return stringBuffer.toString();
    }

    public String[] getNameList(String input){
        String[] namelist = input.split(",");
        for (String name:namelist) {
            checkName(name);
        }
        return namelist;
    }

    public void initScoreBoard(String inputLine){
        scoreboard.clear();
        String[] nameList = getNameList(inputLine);
        for(String name:nameList){
            scoreboard.put(name,0);
        }
    }

    public void run(){
        int tryCount;
        try{
            //게임 초기화
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String inputLine = Console.readLine();
            initScoreBoard(inputLine);

            //시도 횟수 입력
            System.out.println("시도할 회수는 몇회인가요?");
            tryCount = Integer.parseInt(Console.readLine());

            //tryCount를 통해 레이스 진행
            raceProgress(tryCount);

            //최종 승자 계산
            System.out.println("최종 우승자 : " + chooseWinner());

        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
