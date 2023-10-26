package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    //횟수 설정
    public int  numOfGames() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return validation(input);
    }
    //플레이어 설정
    public List<String> setThePlayer(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String player = Console.readLine();
        List<String> PlayerList = Arrays.stream(player.split(",")).map(String::trim).collect(Collectors.toList());
        return PlayerList;
    }
    public List<Integer> setScore(List<String> playerList ){
        List<Integer> scoreList = new ArrayList<>();
        for (String playerName : playerList) {
            scoreList.add(0);
        }
        return scoreList;
    }
    private int validation(String input){
        int num;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
        if (num < 1) {
            throw new IllegalArgumentException("1 이상의 정수를 입력하세요.");
        }
        return num;
    }

}


