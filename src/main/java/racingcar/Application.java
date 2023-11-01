package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        List<String> players =  playerName();
        int playTimes = playTime();
        List<String> results = playGame(players, playTimes);
        List<String> winner = winningPlayer(players, results);
        String winningPlayer = getJoin(winner);
        System.out.println("최종 우승자 : " + winningPlayer);

    }

    private static String getJoin(List<String> winner) {
        return String.join(", ", winner);
    }

    public static List<String> playGame(List<String> players, int playTimes){
        System.out.println("실행 결과");
        List<String> results = playerResults(players);
        for (int round =0; round<playTimes; round++) {
           roundResults(players, results);
           System.out.println();
        }
        return results;
    }
    public static List<String> playerResults(List<String> players){
        List<String> results = getWinningPlayers();
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
        List<String > players = getWinningPlayers();
        String input = getInput();
        String[] names = getNames(input);
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("5자 이내로 입력해주세요");
            }
            players.add(name);
        }
        return players;
    }

    private static String[] getNames(String input) {
        return input.split(",");
    }

    private static String getInput() {
        return Console.readLine();
    }

    public static int playTime(){
        System.out.println("시도할 횟수는 몇회인가요?");
        int playTimes;
        try{
            playTimes = Integer.parseInt(getInput());
            if(playTimes <=0){
                throw new IllegalArgumentException("0보다 큰 숫자를 입력해주세요");
            }
        }catch (Exception e){
            throw new IllegalArgumentException("시도횟수가 숫자가 아닙니다");
        }
        return playTimes;
    }
    public static List<String> winningPlayer(List<String> players, List<String> results){
        int moveDashes = -1;
        List<String> winningPlayers = getWinningPlayers();
        for (int i =0; i < players.size(); i++){
            int dashes = countDashes(results.get(i));
            if(dashes>moveDashes){
                moveDashes = dashes;
                assert winningPlayers != null;
                winningPlayers.add(players.get(i));
            }else if(dashes==moveDashes){
                winningPlayers.add(players.get(i));
            }
        }
       return winningPlayers;
    }

    private static ArrayList<String> getWinningPlayers() {
        return new ArrayList<>();
    }

    public static int countDashes(String str){
        int dashes = 0;
        for (int i =0; i<str.length(); i++){
            if(str.charAt(i)=='-'){
                dashes++;
            }
        }
        return dashes;
    }

}
