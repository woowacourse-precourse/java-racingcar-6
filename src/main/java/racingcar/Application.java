package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        List<String> players =  playerName();
        int playTimes = playTime();
        playGame(players, playTimes);
    }
    public static void playGame(List<String> players, int playTimes){
        System.out.println("실행 결과");
        List<String> results = playerResults(players);

        for (int round =0; round<playTimes; round++) {
           roundResults(players, results);
           System.out.println();
        }

    }
    public static List<String> playerResults(List<String> players){
        List<String> results = new ArrayList<>();
       for (int i=0; i< players.size(); i++){
           results.add("");
       }
        return results;
    }
    public static void roundResults(List<String> players, List<String> results){
        for (int i=0; i<players.size(); i++) {
            int move = Randoms.pickNumberInRange(0, 9);
            String result;
            if (move >= 4) {
                result = "-";
            } else {
                result = "";
            }
            results.set(i, results.get(i) + result);
            System.out.println(players.get(i) + " : " + results.get(i));
        }
    }
    public static List<String> playerName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String > players = new ArrayList<>();
        String input = Console.readLine();
        String[] names = input.split(",");
        for (int i=0; i<names.length; i++) {
            String name = names[i];
            if (name.length() > 5) {
                throw new IllegalArgumentException("5자 이내로 입력해주세요");
            }
            players.add(name);
        }
        return players;
    }
    public static int playTime(){
        System.out.println("시도할 횟수는 몇회인가요?");
        int playTimes;
        try{
            playTimes = Integer.parseInt(Console.readLine());
            if(playTimes <=0){
                throw new IllegalArgumentException("0보다 큰 숫자를 입력해주세요");
            }
        }catch (Exception e){
            throw new IllegalArgumentException("시도횟수가 숫자가 아닙니다");
        }
        return playTimes;
    }

}
