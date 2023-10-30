package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {

    public void startMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public List<String> playerInput(){
        String input = Console.readLine();
        List<String> players = List.of(input.split(","));
        checkPlayersName(players);


        return players;
    }

    public void checkPlayersName(List<String> inputs){
        for (String name : inputs) {
            checkNameLength(name);
        }
    }

    public void checkNameLength(String name){
        if (name.length()>5){
            throw new IllegalArgumentException("입력 값이 5자를 초과합니다.");
        }
    }
}
