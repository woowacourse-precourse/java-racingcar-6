package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingCar {
    List<String> members;
    public Player players;
    public int games;
    public RacingCar(){
        getUser();
        for (String player : members){
            System.out.println(player);
        }
    }

    public void getUser(){
        players = new Player();
        members = players.getMember(Console.readLine());
//        players.printMembers();
    }
}
