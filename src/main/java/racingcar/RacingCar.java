package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingCar {
    List<String> members;
    public Player players;
    public int games;
    public RacingCar(){
        getUser();
        games = getGameNum();
        System.out.println(games);
    }

    public void getUser(){
        players = new Player();
        members = players.getMember(Console.readLine());
//        players.printMembers();
    }

    public int getGameNum(){
        String num = Console.readLine();
        return Integer.parseInt(num);
    }
}
